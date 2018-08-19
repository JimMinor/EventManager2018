/** Creazione Tabelle Entity **/

/**    IMPIEGATO      **/

CREATE TABLE IMPIEGATO (
  nome VARCHAR2(256) NOT NULL,
  cognome VARCHAR2(256) NOT NULL,
  CF VARCHAR(16) NOT NULL,
  stipedio FLOAT(64) NOT NULL,
  username VARCHAR2(32) NOT NULL,
  password VARCHAR2(64) NOT NULL,
  dataAssunzione DATE ,
  impiegatoID INTEGER PRIMARY KEY);
  
  
  /** Popolamento Impiegato **/
  INSERT INTO IMPIEGATO VALUES ('admin','admin','0000000000000000',0,'admin','admin',sysdate,0);
  SELECT  impiegatoID FROM Impiegato WHERE username='' and password='';
  COMMIT;
  
