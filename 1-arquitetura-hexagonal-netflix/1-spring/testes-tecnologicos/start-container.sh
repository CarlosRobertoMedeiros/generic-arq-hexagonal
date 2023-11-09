#! /usr/bin/env bash

#docker-compose -f authorization_server.yml down
#docker-compose -f authorization_server.yml up -d

docker-compose -f C:/Desenvolvimento/sistemas/study-arquitetura-hexagonal/1-arquitetura-hexagonal-netflix/1-spring/testes-tecnologicos/infra/stack-config/stack.yml down
docker-compose -f C:/Desenvolvimento/sistemas/study-arquitetura-hexagonal/1-arquitetura-hexagonal-netflix/1-spring/testes-tecnologicos/infra/stack-config/stack.yml up -d

echo 'Stack started !'