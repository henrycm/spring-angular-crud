------------------------------------------------------------------
--  TABLE DETALLE_PEDIDO
------------------------------------------------------------------

CREATE TABLE DETALLE_PEDIDO
(
   ID                  NUMBER (19),
   CREATED_BY          VARCHAR2 (255 CHAR),
   CREATION_TIME       TIMESTAMP (6),
   MODIFICATION_TIME   TIMESTAMP (6),
   MODIFIED_BY         VARCHAR2 (255 CHAR),
   VERSION             NUMBER (19),
   SKU                 VARCHAR2 (255 CHAR),
   PEDIDO_ID           NUMBER (19)
)
NOCACHE
LOGGING;


------------------------------------------------------------------
--  TABLE PEDIDO
------------------------------------------------------------------

CREATE TABLE PEDIDO
(
   ID                  NUMBER (19),
   CREATED_BY          VARCHAR2 (255 CHAR),
   CREATION_TIME       TIMESTAMP (6),
   MODIFICATION_TIME   TIMESTAMP (6),
   MODIFIED_BY         VARCHAR2 (255 CHAR),
   VERSION             NUMBER (19),
   DESCRIPCION         VARCHAR2 (255 CHAR),
   STATUS              NUMBER (10)
)
NOCACHE
LOGGING;


------------------------------------------------------------------
--  TABLE PERMISSION
------------------------------------------------------------------

CREATE TABLE PERMISSION
(
   ID                  VARCHAR2 (255 CHAR),
   CREATED_BY          VARCHAR2 (255 CHAR),
   CREATION_TIME       TIMESTAMP (6),
   MODIFICATION_TIME   TIMESTAMP (6),
   MODIFIED_BY         VARCHAR2 (255 CHAR),
   VERSION             NUMBER (19),
   NAME                VARCHAR2 (255 CHAR)
)
NOCACHE
LOGGING;


------------------------------------------------------------------
--  TABLE ROLE
------------------------------------------------------------------

CREATE TABLE ROLE
(
   ID     VARCHAR2 (255 CHAR),
   NAME   VARCHAR2 (255 CHAR)
)
NOCACHE
LOGGING;


------------------------------------------------------------------
--  TABLE ROLE_PERMISSIONS
------------------------------------------------------------------

CREATE TABLE ROLE_PERMISSIONS
(
   ROLE_ID          VARCHAR2 (255 CHAR),
   PERMISSIONS_ID   VARCHAR2 (255 CHAR)
)
NOCACHE
LOGGING;


------------------------------------------------------------------
--  TABLE TEST
------------------------------------------------------------------

CREATE TABLE TEST
(
   ID   NUMBER (*, 0)
)
NOCACHE
LOGGING;


------------------------------------------------------------------
--  TABLE T_USER
------------------------------------------------------------------

CREATE TABLE T_USER
(
   ID                  NUMBER (19),
   CREATED_BY          VARCHAR2 (255 CHAR),
   CREATION_TIME       TIMESTAMP (6),
   MODIFICATION_TIME   TIMESTAMP (6),
   MODIFIED_BY         VARCHAR2 (255 CHAR),
   VERSION             NUMBER (19),
   EMAIL               VARCHAR2 (255 CHAR),
   NAME                VARCHAR2 (255 CHAR),
   PASSWORD            VARCHAR2 (255 CHAR),
   USERNAME            VARCHAR2 (255 CHAR)
)
NOCACHE
LOGGING;


------------------------------------------------------------------
--  TABLE T_USER_ROLES
------------------------------------------------------------------

CREATE TABLE T_USER_ROLES
(
   USER_ID    NUMBER (19),
   ROLES_ID   VARCHAR2 (255 CHAR)
)
NOCACHE
LOGGING;


