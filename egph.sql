create table `administrador`(
`id` int auto_increment primary key,
`usuario` varchar(20) not null,
`pass` varchar(50) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table `cajera`(
`id` int auto_increment primary key,
`usuario_cajera` varchar(20) not null,
`pass` varchar(50) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table `factura`(
`id` int auto_increment primary key,
`id_cajera` int not null,
`nombre_cajera` varchar(20),
`nombre_cliente` varchar(40),
`producto` varchar(20) not null,
`cantidad` int not null,
`precio` decimal(2) not null,
`total` decimal(2) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table `inventario`(
`id_inventario` int auto_increment primary key,
`usuario_inventario` varchar(20) not null,
`pass` varchar(50) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table `productos`(
`id_producto` int auto_increment primary key,
`nombre_producto` varchar(20) not null,
`precio` decimal(2) not null,
`cantidad` int not null default 0
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;