CREATE PROCEDURE ins_evento_musicale (new_nome varchar2, new_luogo varchar2, new_data date, new_prezzo float, new_descrizione varchar2, new_tipologia varchar2, new_artista)

@new_id number

BEGIN
    INSERT INTO Evento(ID, nome, luogo, data, prezzo, descrizione, tipologia)
        VALUES('0', new_nome, new_luogo, new_data, new_prezzo, new_descrizione, new_tipologia);
        
    SELECT @new_id=id 
        FROM Evento
        WHERE nome=new_nome, luogo=new_luogo, data=new_data, prezzo=new_prezzo, descrizione=new_descrizione, tipologia=new_tipologia;
        
    INSERT INTO Evento_Musicale(ID, artista)
        VALUES(@new_id, new_artista);
        
END ins_evento_sportivo;