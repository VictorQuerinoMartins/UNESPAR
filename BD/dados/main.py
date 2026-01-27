import sqlite3

conexao = sqlite3.connect('banco.db')
cursor = conexao.cursor()

cursor.execute("CREATE TABLE IF NOT EXISTS contas_bancarias (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, titular TEXT NOT NULL, saldo FLOAT, cpf TEXT NOT NULL UNIQUE)")

# cursor.execute("INSERT INTO contas_bancarias (titular, saldo, cpf) VALUES ('Rodolfo', 0.0, '123.456.789-01')")

cursor.execute("SELECT * FROM contas_bancarias")
contas = cursor.fetchall()
print(contas)

for conta in contas:
    id, titular, saldo, cpf = conta
    print(f'ID: {id} | Titular: {titular} | Saldo: {saldo} | CPF: {cpf}')
    print('---')

conexao.commit()