create table TIPO_PAGAMENTO (
  id serial not null primary key,
  tipo varchar not null,
  pagamento_online bool not null
);

create table FORMA_PAGAMENTO (
  id serial not null primary key,
  id_tipo_pagamento serial not null,
  descricao varchar not null
);

create table USUARIO (
  id serial not null primary key,
  email varchar not null);

create table RESTAURANTE (
  id serial not null primary key,
  nome varchar not null);

create table RESTAURANTE_FORMA_PAGAMENTO (
    id_forma_pagamento serial not null,
    id_restaurante serial not null
);

create table USUARIO_FORMA_PAGAMENTO (
    id_forma_pagamento serial not null,
    id_usuario serial not null
);

alter TABLE public.forma_pagamento ADD CONSTRAINT forma_pagamento_un UNIQUE (id_tipo_pagamento);

alter TABLE public.forma_pagamento ADD CONSTRAINT forma_pagamento_fk FOREIGN KEY (id_tipo_pagamento) REFERENCES public.tipo_pagamento(id);

alter TABLE public.usuario_forma_pagamento ADD CONSTRAINT usuario_forma_pagto_fk1 FOREIGN KEY (id_forma_pagamento) REFERENCES public.forma_pagamento(id);
alter TABLE public.usuario_forma_pagamento ADD CONSTRAINT usuario_forma_pagto_fk2 FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);
