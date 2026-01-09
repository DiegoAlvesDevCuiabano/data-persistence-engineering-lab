INSERT INTO registro_evento_50k (
    tipo,
    status,
    descricao,
    ativo,
    data_criacao
)
SELECT
    CASE
        WHEN n1.n % 10 < 4 THEN 'A'
        WHEN n1.n % 10 < 7 THEN 'B'
        WHEN n1.n % 10 < 9 THEN 'C'
        ELSE 'D'
        END AS tipo,

    CASE
        WHEN n2.n % 10 < 5 THEN 'ATIVO'
        WHEN n2.n % 10 < 7 THEN 'PENDENTE'
        ELSE 'INATIVO'
        END AS status,

    CONCAT(
            'Evento tipo ',
            CASE
                WHEN n1.n % 10 < 4 THEN 'A'
                WHEN n1.n % 10 < 7 THEN 'B'
                WHEN n1.n % 10 < 9 THEN 'C'
                ELSE 'D'
                END,
            ' numero ',
            n1.n,
            '-',
            n2.n
    ) AS descricao,

    CASE
        WHEN n2.n % 10 < 7 THEN 1
        ELSE 0
        END AS ativo,

    DATE_SUB(
                    CURRENT_TIMESTAMP,
                    INTERVAL (n1.n % 365) DAY
    ) AS data_criacao

FROM helper_numbers n1
         CROSS JOIN helper_numbers n2
    LIMIT 50000;
