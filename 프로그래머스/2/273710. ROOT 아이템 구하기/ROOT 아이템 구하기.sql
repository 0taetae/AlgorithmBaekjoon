SELECT it.ITEM_ID, ITEM_NAME
FROM ITEM_TREE it left join ITEM_INFO ii
on it.ITEM_ID = ii.ITEM_ID
where PARENT_ITEM_ID is null
order by ITEM_ID
