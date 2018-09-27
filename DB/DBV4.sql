--------------------------------------------------------
--  File creato - giovedì-settembre-27-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence CL_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."CL_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence EV_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."EV_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 141 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table CLIENTE
--------------------------------------------------------

  CREATE TABLE "ADMIN"."CLIENTE" 
   (	"ID" NUMBER, 
	"USERNAME" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE), 
	"CODICE_FISCALE" VARCHAR2(20 BYTE), 
	"EMAIL" VARCHAR2(20 BYTE), 
	"TELEFONO" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table EVENTO
--------------------------------------------------------

  CREATE TABLE "ADMIN"."EVENTO" 
   (	"ID" NUMBER, 
	"NOME" VARCHAR2(20 BYTE), 
	"LUOGO" VARCHAR2(20 BYTE), 
	"DATA" DATE, 
	"PREZZO" FLOAT(126), 
	"DESCRIZIONE" VARCHAR2(280 BYTE), 
	"TIPOLOGIA" VARCHAR2(20 BYTE), 
	"CITTA" VARCHAR2(20 BYTE), 
	"CAPIENZA_EVENTO" NUMBER, 
	"GENERE" VARCHAR2(8 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table IMPIEGATO
--------------------------------------------------------

  CREATE TABLE "ADMIN"."IMPIEGATO" 
   (	"ID" NUMBER, 
	"CODICE_FISCALE" VARCHAR2(16 BYTE), 
	"USERNAME" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE), 
	"DATA_ASSUNZIONE" DATE, 
	"STIPENDIO" FLOAT(126), 
	"EMAIL" VARCHAR2(30 BYTE), 
	"TELEFONO" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table LUOGO
--------------------------------------------------------

  CREATE TABLE "ADMIN"."LUOGO" 
   (	"NOME_LUOGO" VARCHAR2(20 BYTE), 
	"CITTA" VARCHAR2(20 BYTE), 
	"NUM_POSTI" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PARTECIPANTI_EVENTO
--------------------------------------------------------

  CREATE TABLE "ADMIN"."PARTECIPANTI_EVENTO" 
   (	"ID_EVENTO" NUMBER, 
	"PARTECIPANTE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PERSONA
--------------------------------------------------------

  CREATE TABLE "ADMIN"."PERSONA" 
   (	"CODICE_FISCALE" VARCHAR2(16 BYTE), 
	"NOME" VARCHAR2(20 BYTE), 
	"COGNOME" VARCHAR2(20 BYTE), 
	"DATA_NASCITA" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for View VIEWIMPIEGATO
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "ADMIN"."VIEWIMPIEGATO" ("ID", "CODICE_FISCALE", "NOME", "COGNOME", "DATA", "USERNAME", "PASSWORD", "DATA_ASSUNZIONE", "STIPENDIO", "EMAIL", "TELEFONO") AS 
  SELECT 
    IMPIEGATO.ID, PERSONA.CODICE_FISCALE, PERSONA.NOME, PERSONA.COGNOME, PERSONA.DATA_NASCITA, IMPIEGATO.USERNAME, IMPIEGATO.PASSWORD, IMPIEGATO.DATA_ASSUNZIONE, IMPIEGATO.STIPENDIO, IMPIEGATO.EMAIL, IMPIEGATO.TELEFONO
FROM 
    IMPIEGATO JOIN PERSONA ON IMPIEGATO.CODICE_FISCALE = PERSONA.CODICE_FISCALE
;
REM INSERTING into ADMIN.CLIENTE
SET DEFINE OFF;
Insert into ADMIN.CLIENTE (ID,USERNAME,PASSWORD,CODICE_FISCALE,EMAIL,TELEFONO) values ('9','fpisani','pisa','PSNFBN58C58G702W','f.pisani@gmail.com',null);
Insert into ADMIN.CLIENTE (ID,USERNAME,PASSWORD,CODICE_FISCALE,EMAIL,TELEFONO) values ('10','mlombardo','lomba','LBRMRN66C02F205H','m.lombardo@gmail.com',null);
Insert into ADMIN.CLIENTE (ID,USERNAME,PASSWORD,CODICE_FISCALE,EMAIL,TELEFONO) values ('11','gcocci','coccinella','CCCGLL82R15D612C','g.cocci@gmail.com',null);
Insert into ADMIN.CLIENTE (ID,USERNAME,PASSWORD,CODICE_FISCALE,EMAIL,TELEFONO) values ('12','vudinesi','udine','DNSVGL99B16L483E','v.udinesi@gmail.com',null);
Insert into ADMIN.CLIENTE (ID,USERNAME,PASSWORD,CODICE_FISCALE,EMAIL,TELEFONO) values ('13','mesposito','farfalla','SPSMRC93S12F839V','m.esposito@gmail.com',null);
Insert into ADMIN.CLIENTE (ID,USERNAME,PASSWORD,CODICE_FISCALE,EMAIL,TELEFONO) values ('14','garagona','semplice','RGNGRL02M43H501H','g.aragona@gmail.com',null);
Insert into ADMIN.CLIENTE (ID,USERNAME,PASSWORD,CODICE_FISCALE,EMAIL,TELEFONO) values ('15','mcuomo','formica','CMUMRA65B28H703V','m.cuomo@gmail.com',null);
Insert into ADMIN.CLIENTE (ID,USERNAME,PASSWORD,CODICE_FISCALE,EMAIL,TELEFONO) values ('16','atocchi','toccato','TCCNNL95T58H223U','a.tocchi@gmail.com',null);
REM INSERTING into ADMIN.EVENTO
SET DEFINE OFF;
Insert into ADMIN.EVENTO (ID,NOME,LUOGO,DATA,PREZZO,DESCRIZIONE,TIPOLOGIA,CITTA,CAPIENZA_EVENTO,GENERE) values ('122','King Krule - Live ','PALAPARTENOPE',to_date('30-SEP-18','DD-MON-RR'),'12',null,'MUSICALE','NAPOLI','3000','JAZZ');
REM INSERTING into ADMIN.IMPIEGATO
SET DEFINE OFF;
Insert into ADMIN.IMPIEGATO (ID,CODICE_FISCALE,USERNAME,PASSWORD,DATA_ASSUNZIONE,STIPENDIO,EMAIL,TELEFONO) values ('22','ABCDEFGHI','admin','admin',to_date('07-SEP-18','DD-MON-RR'),'0','admin@ticket.it','2');
REM INSERTING into ADMIN.LUOGO
SET DEFINE OFF;
Insert into ADMIN.LUOGO (NOME_LUOGO,CITTA,NUM_POSTI) values ('SANCARLO','NAPOLI','30000');
Insert into ADMIN.LUOGO (NOME_LUOGO,CITTA,NUM_POSTI) values ('PALAPARTENOPE','NAPOLI','3000');
REM INSERTING into ADMIN.PARTECIPANTI_EVENTO
SET DEFINE OFF;
Insert into ADMIN.PARTECIPANTI_EVENTO (ID_EVENTO,PARTECIPANTE) values ('122','King Krule');
REM INSERTING into ADMIN.PERSONA
SET DEFINE OFF;
Insert into ADMIN.PERSONA (CODICE_FISCALE,NOME,COGNOME,DATA_NASCITA) values ('DMRSRG70L06F839N','Sergio','Di Martino',null);
Insert into ADMIN.PERSONA (CODICE_FISCALE,NOME,COGNOME,DATA_NASCITA) values ('NNCVTR93D06M289A','Vittorio','Iannaco',to_date('06-APR-93','DD-MON-RR'));
Insert into ADMIN.PERSONA (CODICE_FISCALE,NOME,COGNOME,DATA_NASCITA) values ('ABCDEFGHI','admin','admin',to_date('07-SEP-18','DD-MON-RR'));
Insert into ADMIN.PERSONA (CODICE_FISCALE,NOME,COGNOME,DATA_NASCITA) values ('CLBZEI39H30D122B','Ezio','Calabresi',to_date('30-JUN-39','DD-MON-RR'));
Insert into ADMIN.PERSONA (CODICE_FISCALE,NOME,COGNOME,DATA_NASCITA) values ('PSNFBN58C58G702W','Fabiana','Pisani',to_date('18-MAR-58','DD-MON-RR'));
Insert into ADMIN.PERSONA (CODICE_FISCALE,NOME,COGNOME,DATA_NASCITA) values ('NLTSVR92A10F839V','Saverio','Napolitano',to_date('10-JAN-92','DD-MON-RR'));
Insert into ADMIN.PERSONA (CODICE_FISCALE,NOME,COGNOME,DATA_NASCITA) values ('LBRMRN66C02F205H','Mariano','Lombardo',to_date('02-MAR-66','DD-MON-RR'));
Insert into ADMIN.PERSONA (CODICE_FISCALE,NOME,COGNOME,DATA_NASCITA) values ('CCCGLL82R15D612C','Galileo','Cocci',to_date('15-OCT-82','DD-MON-RR'));
Insert into ADMIN.PERSONA (CODICE_FISCALE,NOME,COGNOME,DATA_NASCITA) values ('DNSVGL99B16L483E','Virgilio','Udinesi',to_date('16-FEB-99','DD-MON-RR'));
Insert into ADMIN.PERSONA (CODICE_FISCALE,NOME,COGNOME,DATA_NASCITA) values ('SPSMRC93S12F839V','Marco','Esposito',to_date('12-NOV-93','DD-MON-RR'));
Insert into ADMIN.PERSONA (CODICE_FISCALE,NOME,COGNOME,DATA_NASCITA) values ('RGNGRL02M43H501H','Gabriella','Aragona',to_date('03-AUG-02','DD-MON-RR'));
Insert into ADMIN.PERSONA (CODICE_FISCALE,NOME,COGNOME,DATA_NASCITA) values ('CMUMRA65B28H703V','Mario','Cuomo',to_date('28-FEB-65','DD-MON-RR'));
Insert into ADMIN.PERSONA (CODICE_FISCALE,NOME,COGNOME,DATA_NASCITA) values ('TCCNNL95T58H223U','Antonella','Tocchi',to_date('18-DEC-95','DD-MON-RR'));
--------------------------------------------------------
--  DDL for Index CLIENTE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."CLIENTE_PK" ON "ADMIN"."CLIENTE" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index IMPIEGATO_PK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."IMPIEGATO_PK1" ON "ADMIN"."IMPIEGATO" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index EVENTO_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."EVENTO_UK1" ON "ADMIN"."EVENTO" ("NOME", "LUOGO", "DATA", "PREZZO", "DESCRIZIONE", "TIPOLOGIA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PARTECIPANTI_EVENTO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."PARTECIPANTI_EVENTO_PK" ON "ADMIN"."PARTECIPANTI_EVENTO" ("ID_EVENTO", "PARTECIPANTE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index CLIENTE_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."CLIENTE_UK1" ON "ADMIN"."CLIENTE" ("USERNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index EVENTO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."EVENTO_PK" ON "ADMIN"."EVENTO" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index IMPIEGATO_UK2
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."IMPIEGATO_UK2" ON "ADMIN"."IMPIEGATO" ("CODICE_FISCALE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index IMPIEGATO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."IMPIEGATO_PK" ON "ADMIN"."PERSONA" ("CODICE_FISCALE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index LUOGO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."LUOGO_PK" ON "ADMIN"."LUOGO" ("NOME_LUOGO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index IMPIEGATO_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."IMPIEGATO_UK1" ON "ADMIN"."IMPIEGATO" ("USERNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index CLIENTE_UK2
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."CLIENTE_UK2" ON "ADMIN"."CLIENTE" ("CODICE_FISCALE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Trigger CL_ID_INCREMENT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "ADMIN"."CL_ID_INCREMENT" 
BEFORE INSERT ON CLIENTE
FOR EACH ROW

BEGIN
  SELECT CL_ID_SEQ.NEXTVAL
  INTO   :new.ID
  FROM  DUAL;
END;


/
ALTER TRIGGER "ADMIN"."CL_ID_INCREMENT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger EV_ID_INCREMENT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "ADMIN"."EV_ID_INCREMENT" 
BEFORE INSERT ON EVENTO
FOR EACH ROW

BEGIN
  SELECT EV_ID_SEQ.NEXTVAL
  INTO   :new.ID
  FROM  DUAL;
END;



/
ALTER TRIGGER "ADMIN"."EV_ID_INCREMENT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger ID_INCREMENT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "ADMIN"."ID_INCREMENT" 
BEFORE INSERT ON IMPIEGATO
FOR EACH ROW

BEGIN
  SELECT ID_SEQ.NEXTVAL
  INTO   :new.ID
  FROM  DUAL;
END;



/
ALTER TRIGGER "ADMIN"."ID_INCREMENT" ENABLE;
--------------------------------------------------------
--  DDL for Function INS_EVENTO
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "ADMIN"."INS_EVENTO" 
(new_nome varchar2, new_luogo varchar2, new_data date, new_prezzo float, new_descrizione varchar2, new_tipologia varchar2, new_citta varchar2,
new_cap number, new_genere varchar2)
return NUMBER
IS
new_id number;

BEGIN

    INSERT INTO Evento VALUES('0', new_nome, new_luogo, new_data, new_prezzo, new_descrizione, new_tipologia,
    new_citta,new_cap,new_genere);

        /**SELECT ID  INTO new_id
        FROM Evento 
        WHERE ID=(
        /**nome = new_nome AND luogo = new_luogo AND data = new_data AND prezzo = new_prezzo AND descrizione = new_descrizione AND tipologia=new_tipologia;*/
       SELECT max(ID) INTO new_id from Evento;
        DBMS_OUTPUT.put_line(new_id);
RETURN new_id;

END ins_evento;

/
--------------------------------------------------------
--  Constraints for Table CLIENTE
--------------------------------------------------------

  ALTER TABLE "ADMIN"."CLIENTE" ADD CONSTRAINT "CLIENTE_UK2" UNIQUE ("CODICE_FISCALE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ADMIN"."CLIENTE" ADD CONSTRAINT "CLIENTE_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ADMIN"."CLIENTE" ADD CONSTRAINT "CLIENTE_UK1" UNIQUE ("USERNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ADMIN"."CLIENTE" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."CLIENTE" MODIFY ("CODICE_FISCALE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."CLIENTE" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."CLIENTE" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."CLIENTE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PERSONA
--------------------------------------------------------

  ALTER TABLE "ADMIN"."PERSONA" ADD CONSTRAINT "PERSONA_PK" PRIMARY KEY ("CODICE_FISCALE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ADMIN"."PERSONA" MODIFY ("COGNOME" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."PERSONA" MODIFY ("NOME" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."PERSONA" MODIFY ("CODICE_FISCALE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EVENTO
--------------------------------------------------------

  ALTER TABLE "ADMIN"."EVENTO" MODIFY ("TIPOLOGIA" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."EVENTO" MODIFY ("NOME" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."EVENTO" ADD CONSTRAINT "EVENTO_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ADMIN"."EVENTO" MODIFY ("PREZZO" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."EVENTO" MODIFY ("DATA" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."EVENTO" MODIFY ("LUOGO" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."EVENTO" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."EVENTO" ADD CONSTRAINT "EVENTO_UK1" UNIQUE ("NOME", "LUOGO", "DATA", "PREZZO", "DESCRIZIONE", "TIPOLOGIA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ADMIN"."EVENTO" MODIFY ("CAPIENZA_EVENTO" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."EVENTO" MODIFY ("CITTA" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."EVENTO" MODIFY ("GENERE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PARTECIPANTI_EVENTO
--------------------------------------------------------

  ALTER TABLE "ADMIN"."PARTECIPANTI_EVENTO" MODIFY ("PARTECIPANTE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."PARTECIPANTI_EVENTO" MODIFY ("ID_EVENTO" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."PARTECIPANTI_EVENTO" ADD CONSTRAINT "PARTECIPANTI_EVENTO_PK" PRIMARY KEY ("ID_EVENTO", "PARTECIPANTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table IMPIEGATO
--------------------------------------------------------

  ALTER TABLE "ADMIN"."IMPIEGATO" ADD CONSTRAINT "IMPIEGATO_UK1" UNIQUE ("USERNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ADMIN"."IMPIEGATO" MODIFY ("STIPENDIO" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."IMPIEGATO" MODIFY ("DATA_ASSUNZIONE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."IMPIEGATO" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."IMPIEGATO" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."IMPIEGATO" ADD CONSTRAINT "IMPIEGATO_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ADMIN"."IMPIEGATO" MODIFY ("CODICE_FISCALE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."IMPIEGATO" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."IMPIEGATO" ADD CONSTRAINT "IMPIEGATO_UK2" UNIQUE ("CODICE_FISCALE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table LUOGO
--------------------------------------------------------

  ALTER TABLE "ADMIN"."LUOGO" ADD CONSTRAINT "LUOGO_PK" PRIMARY KEY ("NOME_LUOGO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ADMIN"."LUOGO" MODIFY ("CITTA" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."LUOGO" MODIFY ("NOME_LUOGO" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table CLIENTE
--------------------------------------------------------

  ALTER TABLE "ADMIN"."CLIENTE" ADD CONSTRAINT "CLIENTE_FK1" FOREIGN KEY ("CODICE_FISCALE")
	  REFERENCES "ADMIN"."PERSONA" ("CODICE_FISCALE") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EVENTO
--------------------------------------------------------

  ALTER TABLE "ADMIN"."EVENTO" ADD CONSTRAINT "EVENTO_FK1" FOREIGN KEY ("LUOGO")
	  REFERENCES "ADMIN"."LUOGO" ("NOME_LUOGO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table IMPIEGATO
--------------------------------------------------------

  ALTER TABLE "ADMIN"."IMPIEGATO" ADD CONSTRAINT "IMPIEGATO_FK1" FOREIGN KEY ("CODICE_FISCALE")
	  REFERENCES "ADMIN"."PERSONA" ("CODICE_FISCALE") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PARTECIPANTI_EVENTO
--------------------------------------------------------

  ALTER TABLE "ADMIN"."PARTECIPANTI_EVENTO" ADD CONSTRAINT "FK_EVENTO" FOREIGN KEY ("ID_EVENTO")
	  REFERENCES "ADMIN"."EVENTO" ("ID") ENABLE;
