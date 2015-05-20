/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  20/05/2015 10:06:57                      */
/*==============================================================*/


drop table if exists achats;

drop table if exists adresses;

drop table if exists clients;

drop table if exists comptes;

drop table if exists enseignes;

drop table if exists garanties;

drop table if exists pannes;

drop table if exists prod_gar;

drop table if exists prod_panne;

drop table if exists produits;

drop table if exists reparateurs;

drop table if exists reparations;

drop table if exists vend_gar;

drop table if exists vendeurs;

/*==============================================================*/
/* Table : achats                                               */
/*==============================================================*/
create table achats
(
   id_achat             int not null auto_increment,
   id_produit           int,
   id_client            int,
   id_garantie          int,
   date_achat           date,
   primary key (id_achat)
);

/*==============================================================*/
/* Table : adresses                                             */
/*==============================================================*/
create table adresses
(
   id_adresse           int not null auto_increment,
   numero               int,
   nom_voie             varchar(45),
   code_postal          varchar(45),
   ville                varchar(45),
   primary key (id_adresse)
);

/*==============================================================*/
/* Table : clients                                              */
/*==============================================================*/
create table clients
(
   id_client            int not null auto_increment,
   nom                  varchar(254),
   prenom               varchar(254),
   id_compte            int,
   id_adresse           int,
   id_adresse2          int,
   primary key (id_client)
);

/*==============================================================*/
/* Table : comptes                                              */
/*==============================================================*/
create table comptes
(
   id_compte            int not null auto_increment,
   login                varchar(254),
   pwd                  varchar(254),
   primary key (id_compte)
);

/*==============================================================*/
/* Table : enseignes                                            */
/*==============================================================*/
create table enseignes
(
   id_enseigne          int not null auto_increment,
   nom                  varchar(254),
   versementMensuel     float,
   primary key (id_enseigne)
);

/*==============================================================*/
/* Table : garanties                                            */
/*==============================================================*/
create table garanties
(
   id_garantie          int not null auto_increment,
   duree                int,
   cout                 float,
   primary key (id_garantie)
);

/*==============================================================*/
/* Table : pannes                                               */
/*==============================================================*/
create table pannes
(
   id_panne             int not null auto_increment,
   nom                  varchar(254),
   forfait              varchar(254),
   cout                 float,
   primary key (id_panne)
);

/*==============================================================*/
/* Table : prod_gar                                             */
/*==============================================================*/
create table prod_gar
(
   id_produit           int not null,
   id_garantie          int not null
);

/*==============================================================*/
/* Table : prod_panne                                           */
/*==============================================================*/
create table prod_panne
(
   id_produit           int not null,
   id_panne             int not null
);

/*==============================================================*/
/* Table : produits                                             */
/*==============================================================*/
create table produits
(
   id_produit           int not null auto_increment,
   categorie            varchar(254),
   marque               varchar(254),
   modele               varchar(254),
   urlImg               varchar(254),
   transportable        int,
   garantieConstructeur int,
   garantieIncluse      int,
   primary key (id_produit)
);

/*==============================================================*/
/* Table : reparateurs                                          */
/*==============================================================*/
create table reparateurs
(
   id_reparateur        int not null auto_increment,
   nom                  varchar(254),
   id_compte            int,
   id_adresse           int,
   primary key (id_reparateur)
);

/*==============================================================*/
/* Table : reparations                                          */
/*==============================================================*/
create table reparations
(
   id_reparation        int not null auto_increment,
   id_reparateur        int not null,
   id_panne             int not null,
   id_vendeur           int,
   id_achat             int not null,
   description          varchar(254) not null,
   date_etat            datetime not null,
   etat                 varchar(254) not null,
   payee                int not null,
   primary key (id_reparation)
);

/*==============================================================*/
/* Table : vend_gar                                             */
/*==============================================================*/
create table vend_gar
(
   id_vendeur           int not null,
   id_garantie          int not null
);

/*==============================================================*/
/* Table : vendeurs                                             */
/*==============================================================*/
create table vendeurs
(
   id_vendeur           int not null auto_increment,
   nom                  varchar(254),
   id_enseigne          int,
   id_compte            int,
   id_adresse           int,
   primary key (id_vendeur)
);

alter table achats add constraint FK_Reference_24 foreign key (id_produit)
      references produits (id_produit) on delete restrict on update restrict;

alter table achats add constraint FK_Reference_25 foreign key (id_client)
      references clients (id_client) on delete restrict on update restrict;

alter table achats add constraint FK_Reference_26 foreign key (id_garantie)
      references garanties (id_garantie) on delete restrict on update restrict;

alter table clients add constraint FK_Reference_18 foreign key (id_adresse)
      references adresses (id_adresse) on delete restrict on update restrict;

alter table clients add constraint FK_Reference_20 foreign key (id_adresse2)
      references adresses (id_adresse) on delete restrict on update restrict;

alter table clients add constraint FK_association4 foreign key (id_compte)
      references comptes (id_compte) on delete restrict on update restrict;

alter table prod_gar add constraint FK_Reference_22 foreign key (id_produit)
      references produits (id_produit) on delete restrict on update restrict;

alter table prod_gar add constraint FK_Reference_23 foreign key (id_garantie)
      references garanties (id_garantie) on delete restrict on update restrict;

alter table prod_panne add constraint FK_Reference_10 foreign key (id_panne)
      references pannes (id_panne) on delete restrict on update restrict;

alter table prod_panne add constraint FK_Reference_11 foreign key (id_produit)
      references produits (id_produit) on delete restrict on update restrict;

alter table reparateurs add constraint FK_Reference_21 foreign key (id_adresse)
      references adresses (id_adresse) on delete restrict on update restrict;

alter table reparateurs add constraint FK_association3 foreign key (id_compte)
      references comptes (id_compte) on delete restrict on update restrict;

alter table reparations add constraint FK_Reference_14 foreign key (id_reparateur)
      references reparateurs (id_reparateur) on delete restrict on update restrict;

alter table reparations add constraint FK_Reference_19 foreign key (id_panne)
      references pannes (id_panne) on delete restrict on update restrict;

alter table reparations add constraint FK_Reference_27 foreign key (id_vendeur)
      references vendeurs (id_vendeur) on delete restrict on update restrict;

alter table reparations add constraint FK_Reference_28 foreign key (id_achat)
      references achats (id_achat) on delete restrict on update restrict;

alter table vend_gar add constraint FK_Reference_12 foreign key (id_vendeur)
      references vendeurs (id_vendeur) on delete restrict on update restrict;

alter table vend_gar add constraint FK_Reference_13 foreign key (id_garantie)
      references garanties (id_garantie) on delete restrict on update restrict;

alter table vendeurs add constraint FK_Reference_17 foreign key (id_adresse)
      references adresses (id_adresse) on delete restrict on update restrict;

alter table vendeurs add constraint FK_association1 foreign key (id_enseigne)
      references enseignes (id_enseigne) on delete restrict on update restrict;

alter table vendeurs add constraint FK_association5 foreign key (id_compte)
      references comptes (id_compte) on delete restrict on update restrict;

