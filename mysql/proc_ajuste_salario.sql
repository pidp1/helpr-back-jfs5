
-- Criar procedure para ajustar o salário dos cargos#87


CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_ajuste_salario`(cargo Text, novo_salario DECIMAL)
BEGIN
	update helpr.cargo set salario = novo_salario where nome = cargo;
END