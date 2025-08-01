select ii.ITEM_ID, ii.ITEM_NAME, ii.RARITY
from ITEM_INFO ii join ITEM_TREE it
on ii.ITEM_ID = it.ITEM_ID
where it.PARENT_ITEM_ID
    in (select ITEM_ID
       from ITEM_INFO
        where RARITY = 'rare'
       )
order by ii.ITEM_ID desc