create or replace function ins_evento_musicale (new_nome varchar2, new_luogo varchar2, new_data date, new_prezzo float, new_descrizione varchar2, new_tipologia varchar2, new_artista varchar2)

return NUMBER is new_id NUMBER;

BEGIN
    INSERT INTO Evento(ID, nome, luogo, data, prezzo, descrizione, tipologia)
        VALUES('0', new_nome, new_luogo, new_data, new_prezzo, new_descrizione, new_tipologia);

        SELECT id into new_id 
        FROM Evento
        WHERE nome=new_nome and luogo=new_luogo and data=new_data and prezzo=new_prezzo
        and descrizione=new_descrizione and tipologia=new_tipologia;

    INSERT INTO Evento_Musicale(ID, artista)
        VALUES(new_id, new_artista);
        
        
        RETURN new_id;

END ins_evento_musicale;
