# --- !Ups
CREATE TABLE "interns" ("id" SERIAL PRIMARY KEY ,"name" varchar(200) NOT NULL,"email" varchar(200) NOT NULL, "mobile" varchar(200) NOT NULL,"address" varchar(200) NOT NULL,"emergency" varchar(200) NOT NULL);

INSERT INTO "interns" values (1,'himani', 'himani@knoldus.in','9873215276','delhi',"22510228");
INSERT INTO "interns" values (2,'iman', 'iman@knoldus.in','9873215276','delhi',"22510228");

#---!Downs
DROP TABLE "interns";
