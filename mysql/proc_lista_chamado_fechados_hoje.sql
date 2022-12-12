USE helpr;

SELECT * FROM helpr.chamado;

DELIMITER //

CREATE PROCEDURE proc_lista_chamado_fechados_hoje(SelectedDate DATE)
BEGIN
		SELECT * FROM helpr.chamado WHERE data_fechamento = SelectedDate;
END //

CALL proc_lista_chamado_fechados_hoje('2022-12-11')