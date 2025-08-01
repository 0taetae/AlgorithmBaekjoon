SELECT fi.ID, fni.FISH_NAME, fi.LENGTH
FROM FISH_INFO fi
JOIN FISH_NAME_INFO fni ON fi.FISH_TYPE = fni.FISH_TYPE
WHERE (fi.FISH_TYPE, fi.LENGTH) IN (
    SELECT FISH_TYPE, MAX(LENGTH)
    FROM FISH_INFO
    WHERE LENGTH IS NOT NULL
    GROUP BY FISH_TYPE
)
