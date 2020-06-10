<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

openapi: 3.0.0
info:
  title: Supplier - Search
  license:
    name: MIT
  version: 0.5.0
servers:
- url: /api
  description: API
security:
- token_auth: []
paths:
  /suppliers:
    get:
      tags:
      - Компании
      summary: Получить список поставщиков
      operationId: suppiers_get
      responses:
        "200":
          description: Список поставщиков
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Supplier'
  /supplier/{id}:
    get:
      tags:
      - Компании
      summary: Получить информацию о поставщике
      operationId: suppliers_id_get
      parameters:
      - name: id
        in: path
        description: ID поставщика
        required: true
        style: simple
        schema:
          type: integer
      responses:
        "200":
          description: Поставщик
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Supplier'
  /customers:
    get:
      tags:
      - Компании
      summary: Получить список покупателей
      operationId: customers_get
      responses:
        "200":
          description: Список покупателей
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Customer'
  /customer/{id}:
    get:
      tags:
      - Компании
      summary: Получить информацию о покупателе
      operationId: customers_id_get
      parameters:
      - name: id
        in: path
        description: ID покупателя
        required: true
        style: simple
        schema:
          type: integer
      responses:
        "200":
          description: Покупатель
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Supplier'
  /supplies:
    get:
      tags:
      - Предложения
      summary: Получить список предложений
      operationId: supplies_get
      responses:
        "200":
          description: Список предложений
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Supply'
    post:
      tags:
      - Предложения
      summary: Добавить предложение
      operationId: supplies_post
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Supply'
        required: true
      responses:
        "200":
          description: Предложение создано
  /supply/{id}:
    delete:
      tags:
      - Предложения
      summary: Удалить предложение
      operationId: supplies_id_delete
      parameters:
      - name: id
        in: path
        description: ID предложения
        required: true
        style: simple
        explode: false
        schema:
          type: string
      responses:
        "200":
          description: Предложение удалено
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'
  /requests:
    get:
      tags:
      - Запросы
      summary: Получить список запросов
      operationId: requests_get
      responses:
        "200":
          description: Список запросов
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Request'
    post:
      tags:
      - Запросы
      summary: Добавить запрос
      operationId: requests_post
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Request'
        required: true
      responses:
        "200":
          description: Запрос создан
  /request/{id}:
    delete:
      tags:
      - Запросы
      summary: Удалить запрос
      operationId: requests_id_delete
      parameters:
      - name: id
        in: path
        description: ID запроса
        required: true
        style: simple
        explode: false
        schema:
          type: string
      responses:
        "200":
          description: Запрос удален
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'
components:
  schemas:
    Supplier:
      required:
      - id
      - name
      - about
      - production
      - contacts
      type: object
      properties:
        id:
          type: integer
        name:
          type: string
        about:
          type: string
        production:
          type: string
        contacts:
          type: string
      example:
        id: 1
        name: Рога и копыта
        about: О компании
        production: Рога, копыта
        contacts: admin@admin.ru
    Customer:
      required:
      - id
      - name
      - about
      - procurement
      - contacts
      type: object
      properties:
        id:
          type: integer
        name:
          type: string
        about:
          type: string
        procurement:
          type: string
        contacts:
          type: string
      example:
        id: 1
        name: Рога и копыта
        about: О компании
        production: Рога, копыта
        contacts: admin@admin.ru
    Supply:
      required:
      - id
      - supplier_id
      - category
      - city
      - description
      - date
      type: object
      properties:
        id:
          type: integer
        supplier_id:
          type: integer
        category:
          type: string
        city:
          type: string
        description:
          type: string
        date:
          type: string
      example:
        id: 1
        supplier_id: 1
        category: Рога
        city: Воронеж
        description: Рога отборные
        date: 01.01.2020
    Request:
      required:
      - id
      - customer_id
      - category
      - city
      - amount
      - frequency
      - description
      - date
      type: object
      properties:
        id:
          type: integer
        customer_id:
          type: integer
        category:
          type: string
        city:
          type: string
        amount:
          type: string
        frequency:
          type: string
        description:
          type: string
        date:
          type: string
      example:
        id: 1
        customer_id: 1
        category: Рога
        city: Воронеж
        amount: 10
        frequency: 1
        description: Требуются рога
        date: 01.01.2020
    Error:
      required:
      - message
      type: object
      properties:
        message:
          type: string
  securitySchemes:
    token_auth:
      type: apiKey
      name: token
      in: header
