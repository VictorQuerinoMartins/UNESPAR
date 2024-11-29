//Consultas básicas:

//a) Selecionar colunas específicas, sem nenhuma condição:
//SELECT Descricao, Preco FROM Produto;

//b) Selecionar colunas específicas atribuindo alguma condição:
//SELECT Descricao, Preco FROM Produto WHERE Preco > 15.00;


//c) Alterar o valor de algum registro:
//UPDATE Produto SET Preco = 12.50 WHERE Codigo = 3;

//d) Deletar um registro:
//DELETE FROM Produto WHERE Codigo = 10;

//e) Fazer uma seleção que retorne a contagem de registros:
//SELECT COUNT(*) AS TotalProdutos FROM Produto;

//f) Selecionar Descrição e Preço e ordenar por preço:
//SELECT Descricao, Preco FROM Produto ORDER BY Preco;

//g) Selecionar todos os registros por ordem de descrição:
//SELECT * FROM Produto ORDER BY Descricao;