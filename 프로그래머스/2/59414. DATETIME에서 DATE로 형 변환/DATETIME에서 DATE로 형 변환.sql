-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, date_format(DATETIME, '%Y-%m-%d') as '날짜'
from ANIMAL_INS
ORDER BY ANIMAL_ID