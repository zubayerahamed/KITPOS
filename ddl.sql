 create table business
              (
                           businessId  varchar(255) not null
                         , counter     varchar(255) not null
                         , division    varchar(255) not null
                         , shop        varchar(255) not null
                         , createdBy   varchar(255)
                         , createdFrom varchar(255)
                         , createdOn datetime2
                         , modifiedBy  varchar(255)
                         , updatedFrom varchar(255)
                         , updatedOn datetime2
                         , address  varchar(255)
                         , currency varchar(255)
                         , email    varchar(255)
                         , logo     varchar(255)
                         , name     varchar(255)
                         , phone    varchar(255)
                         , status   int
                         , tinNp    varchar(255)
                         , vatRegNo varchar(255)
                         , website  varchar(255)
                         , xdformat varchar(255)
                         , primary key (businessId, counter, division, shop)
              )
 create table US
              (
                           businessId  varchar(255) not null
                         , counter     varchar(255) not null
                         , division    varchar(255) not null
                         , shop        varchar(255) not null
                         , username    varchar(255) not null
                         , createdBy   varchar(255)
                         , createdFrom varchar(255)
                         , createdOn datetime2
                         , modifiedBy  varchar(255)
                         , updatedFrom varchar(255)
                         , updatedOn datetime2
                         , admin       bit not null
                         , cashier     bit not null
                         , name        varchar(255)
                         , password    varchar(255)
                         , status      int
                         , systemadmin bit not null
                         , userType    varchar(255)
                         , waiter      bit not null
                         , primary key (businessId, counter, division, shop, username)
              )