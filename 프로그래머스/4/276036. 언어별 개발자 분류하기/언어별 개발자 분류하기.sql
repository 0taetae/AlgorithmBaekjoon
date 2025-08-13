SELECT DISTINCT t.GRADE, t.ID, t.EMAIL
FROM (
    SELECT d.ID, d.EMAIL,
        CASE
            WHEN (d.SKILL_CODE & fe.FE_CODE > 0) AND (d.SKILL_CODE & p.CODE > 0)
                THEN 'A'
            WHEN d.SKILL_CODE & c.CODE > 0
                THEN 'B'
            WHEN d.SKILL_CODE & fe.FE_CODE > 0
                THEN 'C'
        END AS GRADE
    FROM DEVELOPERS d
    JOIN (
        SELECT BIT_OR(CODE) AS FE_CODE
        FROM SKILLCODES
        WHERE CATEGORY = 'Front End'
    ) fe
    JOIN (SELECT CODE FROM SKILLCODES WHERE NAME = 'Python') p
    JOIN (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#') c
) t
WHERE GRADE IS NOT NULL
ORDER BY GRADE, ID;
