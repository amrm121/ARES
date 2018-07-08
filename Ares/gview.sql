CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`%` 
    SQL SECURITY DEFINER
VIEW `vw_consumer_geracao_ordem` AS
    SELECT 
        LPAD(`vendas`.`idvendas`, 4, 0) AS `Nº DO PEDIDO`,
        `us`.`nome` AS `SOLICITANTE`,
        `dadosordem`.`operadora` AS `REGIONAL`,
        CURDATE() AS `DATA DA SOLICITAÇÃO`,
        `dadosordem`.`emissor` AS `EMISSOR`,
        `dadosordem`.`empresa` AS `EMPRESA`,
        `vendas`.`cliente` AS `NOME`,
        `vendas`.`cpf` AS `CPF`,
        `vendas`.`contato` AS `TELEFONE DE CONTATO`,
        `vendas`.`cidade` AS `MUNIPÍCIO`,
        `uf`.`uf_sigla` AS `UF`,
        `vendas`.`endereco` AS `ENDEREÇO`,
        `vendas`.`numero` AS `NÚMERO`,
        `vendas`.`complemento` AS `COMPLEMENTO`,
        `vendas`.`bairro` AS `BAIRRO`,
        `vendas`.`cep_endereco` AS `CEP`,
        `vendas`.`ponto_ref1` AS `PONTO DE REFERÊNCIA`,
        CONCAT(`vendas`.`pessoa_autorizada1`,
                ', ',
                `vendas`.`pessoa_autorizada2`) AS `PESSOAS AUTORIZADAS`,
        `dadosordem`.`codigo_material` AS `CÓDIGO MATERIAL TM`,
        (SELECT 
                (COUNT(`vendas_dependentes`.`idvendas`) + 1)
            FROM
                `vendas_dependentes`
            WHERE
                (`vendas_dependentes`.`idvendas` = `vendas`.`idvendas`)) AS `QTDE DE CHIP(S)`,
        `dadosordem`.`canal` AS `CANAL`,
        `vendas`.`data_venda` AS `data_venda`
    FROM
        (((`vendas`
        LEFT JOIN `uf` ON ((`vendas`.`regiao` = `uf`.`uf_codigo`)))
        LEFT JOIN `usuario` `us` ON ((`vendas`.`idusuario` = `us`.`idusuario`)))
        JOIN `dadosordem` ON ((CONVERT( `uf`.`uf_sigla` USING UTF8) = `dadosordem`.`uf`)))