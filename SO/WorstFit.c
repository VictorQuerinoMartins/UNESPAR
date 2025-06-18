#include <iostream>
#include <list>
#include <algorithm> // Para std::max_element

// Estrutura para representar um bloco de memória
struct BlocoMemoria {
    int endereco;
    int tamanho;
    int pid; // Process ID (0 para livre, >0 para alocado)

    // Construtor com lista de inicializadores
    BlocoMemoria(int addr, int size, int p) : endereco(addr), tamanho(size), pid(p) {}
};

// Classe para gerenciar a memória usando Worst Fit
class MemoriaWorstFit {
private:
    std::list<BlocoMemoria> blocos_livres;
    std::list<BlocoMemoria> blocos_alocados;
    int proximo_pid; // Contador para gerar IDs de processo

    // Função auxiliar para imprimir o estado da memória
    void imprimirEstadoMemoria() const { // Marcado como const pois não modifica o objeto
        std::cout << "\n--- Estado Atual da Memoria ---" << std::endl;
        std::cout << "Blocos Livres:" << std::endl;
        if (blocos_livres.empty()) {
            std::cout << "  Nenhum bloco livre." << std::endl;
        } else {
            // Cria uma cópia para ordenação (já que list não permite acesso aleatório para sort)
            std::list<BlocoMemoria> sorted_livres = blocos_livres;
            sorted_livres.sort([](const BlocoMemoria& a, const BlocoMemoria& b) {
                return a.endereco < b.endereco;
            });
            for (const auto& bloco : sorted_livres) {
                std::cout << "  Endereco: " << bloco.endereco << ", Tamanho: " << bloco.tamanho << " KB (Livre)" << std::endl;
            }
        }

        std::cout << "Blocos Alocados:" << std::endl;
        if (blocos_alocados.empty()) {
            std::cout << "  Nenhum bloco alocado." << std::endl;
        } else {
            // Cria uma cópia para ordenação
            std::list<BlocoMemoria> sorted_alocados = blocos_alocados;
            sorted_alocados.sort([](const BlocoMemoria& a, const BlocoMemoria& b) {
                return a.endereco < b.endereco;
            });
            for (const auto& bloco : sorted_alocados) {
                std::cout << "  PID " << bloco.pid << ": Endereco: " << bloco.endereco << ", Tamanho: " << bloco.tamanho << " KB (Alocado)" << std::endl;
            }
        }
        std::cout << "------------------------------" << std::endl;
    }

public:
    // Construtor: Inicializa a memória com um único bloco livre
    MemoriaWorstFit(int tamanhoTotalMemoria) : proximo_pid(1) {
        blocos_livres.push_back(BlocoMemoria(0, tamanhoTotalMemoria, 0));
    }

    // Aloca um processo usando o algoritmo Worst Fit
    int alocar(int tamanhoProcesso) {
        imprimirEstadoMemoria();
        std::cout << "\nTentando alocar " << tamanhoProcesso << " KB..." << std::endl;

        if (tamanhoProcesso <= 0) {
            std::cout << "Erro: O tamanho do processo deve ser maior que zero." << std::endl;
            return -1;
        }

        auto it_maior_bloco = blocos_livres.end();
        int maior_tamanho_livre = -1;

        // Encontra o maior bloco livre que seja grande o suficiente
        for (auto it = blocos_livres.begin(); it != blocos_livres.end(); ++it) {
            if (it->tamanho >= tamanhoProcesso && it->tamanho > maior_tamanho_livre) {
                maior_tamanho_livre = it->tamanho;
                it_maior_bloco = it;
            }
        }

        if (it_maior_bloco == blocos_livres.end()) {
            std::cout << "Falha na alocacao: Nao ha nenhum bloco livre grande o suficiente para " << tamanhoProcesso << " KB." << std::endl;
            return -1;
        }

        // Realiza a alocação
        BlocoMemoria bloco_escolhido = *it_maior_bloco;
        blocos_livres.erase(it_maior_bloco);

        int pid_atual = proximo_pid++;
        blocos_alocados.push_back(BlocoMemoria(bloco_escolhido.endereco, tamanhoProcesso, pid_atual));

        // Se sobrou espaço, adiciona o restante como um novo bloco livre
        if (bloco_escolhido.tamanho > tamanhoProcesso) {
            blocos_livres.push_back(BlocoMemoria(bloco_escolhido.endereco + tamanhoProcesso,
                                                 bloco_escolhido.tamanho - tamanhoProcesso, 0));
        }

        std::cout << "Sucesso: Processo PID " << pid_atual << " alocado em " << bloco_escolhido.endereco
                  << " com " << tamanhoProcesso << " KB." << std::endl;
        return pid_atual;
    }

    // Desaloca um processo
    bool desalocar(int pid) {
        imprimirEstadoMemoria();
        std::cout << "\nTentando desalocar PID " << pid << "..." << std::endl;

        auto it_alocado = blocos_alocados.begin();
        while (it_alocado != blocos_alocados.end() && it_alocado->pid != pid) {
            ++it_alocado;
        }

        if (it_alocado == blocos_alocados.end()) {
            std::cout << "Erro: PID " << pid << " nao encontrado como um processo alocado." << std::endl;
            return false;
        }

        BlocoMemoria bloco_desalocado = *it_alocado;
        blocos_alocados.erase(it_alocado);

        // Adiciona o bloco de volta à lista de blocos livres (PID 0)
        blocos_livres.push_back(BlocoMemoria(bloco_desalocado.endereco, bloco_desalocado.tamanho, 0));

        std::cout << "Sucesso: Processo PID " << pid << " desalocado de " << bloco_desalocado.endereco
                  << " com " << bloco_desalocado.tamanho << " KB." << std::endl;
        return true;
    }
};

// Exemplo de Uso
int main() {
    MemoriaWorstFit memoria(1000); // Memória total de 1000 KB

    // Realiza algumas alocações
    int pid1 = memoria.alocar(100);
    int pid2 = memoria.alocar(200);
    int pid3 = memoria.alocar(50);

    // Desaloca um processo para criar um "buraco"
    std::cout << "\n--- Criando alguns 'buracos' ---" << std::endl;
    memoria.desalocar(pid2);

    // Aloca um novo processo. O Worst Fit deverá usar o maior bloco livre disponível.
    int pid4 = memoria.alocar(75);

    // Desaloca mais alguns processos
    memoria.desalocar(pid1);
    memoria.desalocar(pid3);

    // Aloca mais um processo para ver o estado final
    int pid5 = memoria.alocar(150);

    memoria.imprimirEstadoMemoria(); // Imprime o estado final da memória

    // Tenta alocar um tamanho muito grande (deve falhar se não houver espaço suficiente)
    memoria.alocar(1000);
    
    memoria.imprimirEstadoMemoria();

    return 0;
}