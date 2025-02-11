INSERT INTO pessoa (nome, endereco, cep, cidade, uf) VALUES
('João Silva', 'Rua das Flores, 123', '12345-678', 'São Paulo', 'SP'),
('Maria Oliveira', 'Av. Brasil, 456', '98765-432', 'Rio de Janeiro', 'RJ'),
('Carlos Santos', 'Rua da Paz, 789', '45678-123', 'Belo Horizonte', 'MG');

INSERT INTO contato (tipo_contato, contato, pessoa_id) VALUES
('TELEFONE', '1122334455', 1),
('CELULAR', '11987654321', 1),
('CELULAR', '21999887766', 2),
('TELEFONE', '3133445566', 3),
('CELULAR', '31988776655', 3);
