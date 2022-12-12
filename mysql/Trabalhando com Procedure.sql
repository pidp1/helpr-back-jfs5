-- CHAMADO ------------------------

-- Dados de Teste --
insert into helpr.chamado (data_abertura, descricao, status, titulo , id_cliente, id_funcionario) values ('2022-12-12','teste Elaine 2', 'RECEBIDO','Ativar VPN do sistema',11,1);

-- Select para usar na procedure
select * from helpr.chamado where data_abertura = CURRENT_DATE;

-- Chamada da Procedure
call proc_lista_chamado_aberto_hoje();



-- CARGO ------------------------

-- Dados de Teste --
insert into cargo (descricao, nome, salario) values ('teste Elaine','Estagiário', 5000);

select * from cargo;

-- Update para usar na procedure
update helpr.cargo set salario = 6000 where nome = 'Estagiário';

-- Chamada da Procedure
call proc_ajuste_salario('Estagiário',500);

