// Uma pequena loja de artesanato possui apenas um vendedor e comercializa dez tipos de objetos. O vendedor recebe, mensalmente, salário de R$ 545,00, acrescido de 5% do valor total de suas vendas. O valor unitário dos objetos deve ser informado e armazenado em um vetor; a quantidade vendida de cada peça deve ficar em outro vetor, mas na mesma posição. Crie um programa que receba os preços e as quantidades vendidas, armazenando-os em seus respectivos vetores (ambos com tamanho dez). Depois,determine e mostre:
//● um relatório contendo: quantidade vendida, valor unitário e valor total de cada objeto. Ao final, deverão ser mostrados o valor geral das vendas e o valor da comissão que será paga ao vendedor; 
//● O valor do objeto mais vendido e sua posição no vetor (não se preocupe comempates).


main()
{
    float preco[3];
    int qtddevendas[3]

        for(int i = 0; i < 3; i++)
    {
        printf("Objeto: ");
        scanf("%d", &preco[i]);
        printf("Quantidade vendida: ");
        scanf("%d", &qtddevendas[i]);
    }
    for(int i =0; i < 3; i++){
        printf("Quantidade vendida do objeto %d: %d", i + 1, qtddevendas[i]);
    }
}