select * from producto;

select * from detalle_pedido;

select * from usuario;

select * from pedido pe;
insert into pedido(usuario_id, fecha_pedido, total) values (5, now(), 400);

select * from detalle_pedido;
insert into detalle_pedido (pedido_id, producto_id, cantidad, subtotal, estado) values (4,1,4,4000);

select us.nombre,
       dp.estado,
       ca.nombre
from detalle_pedido dp
    join pedido pe on pe.id = dp.pedido_id
join usuario us on us.id = pe.usuario_id
join producto pr on pr.id = dp. producto_id
join categoria ca on ca.id = pr.categoria_id
where dp.estado = ?;

select * from categoria;

insert into pedido (usuario_id, fecha_pedido, total) VALUES (5,now() - INTERVAL 1 MONTH ,4000);

select us.id,
       pe.id,
       pe.usuario_id,
       us.nombre as 'Usuario',
       ca.nombre as 'Categoria',
       dp.estado as 'Estado Pedido'
       from detalle_pedido dp
                join pedido pe on pe.id = dp.pedido_id

           left join usuario us on us.id = pe.id

           join producto pr on pr.id = dp.producto_id
                join categoria ca on ca.id = pr.id
           ;

alter table detalle_pedido
add estado varchar(10);



update detalle_pedido set estado = 'PREPARADO' where id = 1;
update detalle_pedido set estado = 'ENVIADO' where id = 2;
update detalle_pedido set estado = 'ENTREGADO' where id = 3;