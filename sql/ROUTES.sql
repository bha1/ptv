CREATE TABLE ROUTES(
ROUTE_TYPE VARCHAR(1) NOT NULL,
ROUTE_ID VARCHAR(5) NOT NULL,
ROUTE_NAME VARCHAR(50) NOT NULL,
ROUTE_NUMBER VARCHAR(5),
CONSTRAINT ROUTES_PX PRIMARY KEY (ROUTE_ID,ROUTE_NUMBER)
);