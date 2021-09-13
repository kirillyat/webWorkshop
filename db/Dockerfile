FROM postgres:latest
LABEL maintainer="kirillyat@gmail.com"

ADD scripts/1_init.sql /docker-entrypoint-initdb.d
ADD scripts/2_copy.sql /docker-entrypoint-initdb.d
RUN chmod a+r /docker-entrypoint-initdb.d/*

EXPOSE 5432

