// PROJETO DE IRRIGAÇÃO TINKERCAD


//#include <LiquidCrystal.h>

int PINO_RS = 3;
int PINO_EN = 4;
int PINO_D4 = A2;
int PINO_D5 = A3;
int PINO_D6 = A4;
int PINO_D7 = A5;

int PINO_SENSOR_UMIDADE = A0; 
int PINO_MOTOR = 5;           // Bomba de irrigação
int PINO_SENSOR_CHUVA = 9;    // Sensor de chuva
int PINO_LED_CHUVA = 10;      // LED chuva

const int PINO_TRIG = 11;           // Trigger HC
const int PINO_ECHO = 12;           // Echo HC

// Constantes 
const int LIMIAR_UMIDADE_SECA = 450; 
const int LIMIAR_DISTANCIA_NIVEL_BAIXO = 30; // Distância (cm) do sensor à água

const long TEMPO_LIMITE_ULTRASONICO_US = 20000; // Tempo limite para leitura

// Variáveis Globais
LiquidCrystal lcd(PINO_RS, PINO_EN, PINO_D4, PINO_D5, PINO_D6, PINO_D7);
int valorUmidadeSolo = 0;
int estaChovendo = 0;
long duracaoUltrassonica;
int distanciaAguaCm; // Distância medida pelo sensor ultrasônico

// Protótipos das Funçõe
void inicializarLCD();
void configurarPinos();
int lerUmidadeSolo();
int lerSensorChuva();
int medirDistanciaAgua();
void atualizarSistemaIrrigacao(int umidade, int statusChuva, int distanciaAgua);
void exibirNoLCD(int umidade, int statusChuva, int distanciaAgua, bool bombaLigada);


void setup() {
  inicializarLCD();
  configurarPinos();
}


void loop() {
  valorUmidadeSolo = lerUmidadeSolo();
  estaChovendo = lerSensorChuva();
  distanciaAguaCm = medirDistanciaAgua();

  atualizarSistemaIrrigacao(valorUmidadeSolo, estaChovendo, distanciaAguaCm);

  delay(2000);
  lcd.clear();
}

// Funções

void inicializarLCD() {
  lcd.begin(16, 2);
  lcd.print("Iniciando...");
  delay(1000);
  lcd.clear();
}

void configurarPinos() {
  pinMode(PINO_MOTOR, OUTPUT);
  pinMode(PINO_SENSOR_CHUVA, INPUT);
  pinMode(PINO_LED_CHUVA, OUTPUT);
  pinMode(PINO_TRIG, OUTPUT);
  pinMode(PINO_ECHO, INPUT);

  digitalWrite(PINO_MOTOR, LOW);
  digitalWrite(PINO_LED_CHUVA, LOW);
}

int lerUmidadeSolo() {
  return analogRead(PINO_SENSOR_UMIDADE);
}

int lerSensorChuva() {
  return digitalRead(PINO_SENSOR_CHUVA);
}

int medirDistanciaAgua() {
  digitalWrite(PINO_TRIG, LOW); //Inicia no LOW
  delayMicroseconds(2);
  digitalWrite(PINO_TRIG, HIGH); // Envia pulso
  delayMicroseconds(10);
  digitalWrite(PINO_TRIG, LOW);

  duracaoUltrassonica = pulseIn(PINO_ECHO, HIGH, TEMPO_LIMITE_ULTRASONICO_US);

  if (duracaoUltrassonica > 0) { // Se pulso for recebido
    return duracaoUltrassonica * 0.0343 / 2; // Calculo da distância em cm
  } else {
    return -1;
  }
}

void atualizarSistemaIrrigacao(int umidade, int statusChuva, int distanciaAgua) {
  bool bombaEstaLigada = false;

  if (statusChuva == HIGH) { // Se chovendo
    digitalWrite(PINO_MOTOR, LOW);
    digitalWrite(PINO_LED_CHUVA, HIGH);
    exibirNoLCD(umidade, statusChuva, distanciaAgua, false);
  } else { 
    digitalWrite(PINO_LED_CHUVA, LOW);

    if (distanciaAgua != -1 && distanciaAgua >= LIMIAR_DISTANCIA_NIVEL_BAIXO) { // Se nível de água baixo (distância >= 30cm)
      digitalWrite(PINO_MOTOR, LOW);
      exibirNoLCD(umidade, statusChuva, distanciaAgua, false);
      lcd.setCursor(0, 0);
      lcd.print("NIVEL BAIXO!");
      delay(1500);
      return;
    }

    if (umidade >= LIMIAR_UMIDADE_SECA) { // Solo úmido
      digitalWrite(PINO_MOTOR, LOW);
      exibirNoLCD(umidade, statusChuva, distanciaAgua, false);
    } else { // Solo seco
      digitalWrite(PINO_MOTOR, HIGH);
      bombaEstaLigada = true;
      exibirNoLCD(umidade, statusChuva, distanciaAgua, true);
    }
  }
}

void exibirNoLCD(int umidade, int statusChuva, int distanciaAgua, bool bombaLigada) {
  lcd.clear();

  if (statusChuva == HIGH) { // Se chovendo
    lcd.setCursor(0, 0);
    lcd.print("CHUVENDO!");
  } else if (distanciaAgua != -1 && distanciaAgua >= LIMIAR_DISTANCIA_NIVEL_BAIXO) { // Se nível de água baixo
    lcd.setCursor(0, 0);
    lcd.print("NIVEL BAIXO! ");
    if (distanciaAgua != -1) {
      lcd.print(distanciaAgua);
      lcd.print("cm");
    } else {
      lcd.print("Erro");
    }
  } else { // Se não chovendo e nível OK
    lcd.setCursor(0, 0);
    lcd.print("Nao chovendo.");
  }

  // Segunda linha: Umidade e Status da Bomba
  lcd.setCursor(0, 1);
  lcd.print("Umidade: ");
  lcd.print(umidade);

  lcd.setCursor(12, 1);
  if (bombaLigada) {
    lcd.print("B.ON");
  } else {
    lcd.print("B.OFF");
  }
}