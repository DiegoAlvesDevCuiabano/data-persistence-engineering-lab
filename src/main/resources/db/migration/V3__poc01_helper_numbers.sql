SET SESSION cte_max_recursion_depth = 10000;

CREATE TABLE IF NOT EXISTS helper_numbers (n INT PRIMARY KEY);

INSERT INTO helper_numbers
WITH RECURSIVE nums AS (
    SELECT 1 AS n
    UNION ALL
    SELECT n + 1 FROM nums WHERE n < 10000
)
SELECT n FROM nums;

SET SESSION cte_max_recursion_depth = 1000;