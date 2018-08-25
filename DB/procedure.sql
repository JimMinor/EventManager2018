ALTER TABLE EVENTO
ADD CONSTRAINT EVENTO_UK1 UNIQUE 
(
  NOME 
, LUOGO 
, DATA 
, PREZZO 
, DESCRIZIONE 
, TIPOLOGIA 
)
ENABLE;




create or replace PROCEDURE ins_evento_musicale (new_nome varchar2, new_luogo varchar2, new_data date, new_prezzo float, new_descrizione varchar2, new_tipologia varchar2, new_artista varchar2)
IS
new_id number;

BEGIN

    INSERT INTO Evento(ID, nome, luogo, data, prezzo, descrizione, tipologia)
        VALUES('0', new_nome, new_luogo, new_data, new_prezzo, new_descrizione, new_tipologia);

    SELECT id
        INTO new_id
        FROM Evento
        WHERE nome = new_nome AND luogo = new_luogo AND data = new_data AND prezzo = new_prezzo AND descrizione = new_descrizione AND tipologia=new_tipologia;

    INSERT INTO Evento_Musicale(ID, artista)
        VALUES(new_id, new_artista);

END ins_evento_musicale;




DECLARE
  NEW_NOME VARCHAR2(200);
  NEW_LUOGO VARCHAR2(200);
  NEW_DATA DATE;
  NEW_PREZZO FLOAT;
  NEW_DESCRIZIONE VARCHAR2(200);
  NEW_TIPOLOGIA VARCHAR2(200);
  NEW_ARTISTA VARCHAR2(200);
BEGIN
  NEW_NOME := 'Concerto Ligabue';
  NEW_LUOGO := 'PALAPARTENOPE';
  NEW_DATA := to_date('2018-08-25','yyyy-MM-dd');
  NEW_PREZZO := 40;
  NEW_DESCRIZIONE := 'Concerto di Ligabue al Palapartenope di Napoli il 25/08/18';
  NEW_TIPOLOGIA := 'MUSICALE';
  NEW_ARTISTA := 'LIGABUE';

  INS_EVENTO_MUSICALE(
    NEW_NOME => NEW_NOME,
    NEW_LUOGO => NEW_LUOGO,
    NEW_DATA => NEW_DATA,
    NEW_PREZZO => NEW_PREZZO,
    NEW_DESCRIZIONE => NEW_DESCRIZIONE,
    NEW_TIPOLOGIA => NEW_TIPOLOGIA,
    NEW_ARTISTA => NEW_ARTISTA
  );
--rollback; 
END;