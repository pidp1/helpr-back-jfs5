-- Criar procedure que lista os chamados abertos no dia#85 
-- Crie uma procedure que lista os chamados que foram abertos na data do dia.
-- Observação: o código da procedure deve ser entregue dentro da pasta sql na raiz do projeto seguindo o padrão de nome.
-- Sugestão de nome: proc_lista_chamado_aberto_hoje.sql 

CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_lista_chamado_aberto_hoje`()
BEGIN
	select * from helpr.chamado where data_abertura = CURRENT_DATE;
END

