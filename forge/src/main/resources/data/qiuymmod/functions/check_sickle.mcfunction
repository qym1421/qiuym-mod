execute as @a[nbt={SelectedItem:{id:"qiuymmod:sickle",Count:1b}}] run effect give @s regeneration infinite 255 true
execute as @a[nbt={SelectedItem:{id:"qiuymmod:sickle",Count:1b}}] run function qiuymmod:tag_sickle
execute as @a[nbt=!{SelectedItem:{id:"qiuymmod:sickle",Count:1b}},tag=has_sickle] run effect clear @s[nbt={ActiveEffects:[{"forge:id":"minecraft:regeneration"}]}]
execute as @a[nbt=!{SelectedItem:{id:"qiuymmod:sickle",Count:1b}},tag=has_sickle] run tag @s remove has_sickle
