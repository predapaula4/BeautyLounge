insert into brand(brand_id, brand_name)
values (123, 'Maybelline');
insert into brand(brand_id, brand_name)
values (124, 'Essence');
insert into brand(brand_id, brand_name)
values (125, 'Revlon');
insert into brand(brand_id, brand_name)
values (126, 'NYX');
insert into brand(brand_id, brand_name)
values (127, 'Makeup Revolution');

insert into skin(name, brand_id, category, texture, quantity, price)
values ('primer', 123, 'face', 'creamy', 125, 50);
insert into skin(name, brand_id, category, texture, quantity, price)
values ('foundation', 126, 'face','mousse', 75, 99);
insert into skin(name, brand_id, category, texture, quantity, price)
values ('foundation', 127, 'face', 'liquid', 50, 6);

insert into eye(name, brand_id, category, texture, quantity, price)
values ('eyeshadow cream stick', 124, 'eyes', 'metallic, cream', 100, 35);
insert into eye(name, brand_id, category, texture, quantity, price)
values ('eyeliner', 126, 'eyes', 'creamy', 80, 50);
insert into eye(name, brand_id, category, texture, quantity, price)
values ('eyeshadow palette', 127, 'eyes', 'matte, glitter', 60, 100);

insert into lips(name, brand_id, category, texture, quantity, price)
values ('lip gloss', 125, 'lips', 'metallic, cream', 100, 35);
insert into lips(name, brand_id, category, texture, quantity, price)
values ('pencil', 126, 'lips', 'creamy', 80, 50);
insert into lips(name, brand_id, category, texture, quantity, price)
values ('lip balm', 123, 'lips', 'creamy', 60, 100);

insert into eyebrows(name, brand_id, category, texture, quantity, price)
values ('pencil', 125, 'eyebrow', 'cream', 100, 35);
insert into eyebrows(name, brand_id, category, texture, quantity, price)
values ('brow mascara', 123, 'eyebrow', 'liquid', 80, 50);
insert into eyebrows(name, brand_id, category, texture, quantity, price)
values ('eyebrow gel', 124, 'eyebrow', 'creamy', 60, 100);

insert into beauty_lounge(name, hq_address, year_of_establishment)
values('Beauty Lounge', '25 Market Street First Market Tower 32nd Floor, San Francisco, California, United States', 1990);



