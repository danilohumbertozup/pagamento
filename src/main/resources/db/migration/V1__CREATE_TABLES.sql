CREATE TABLE TIPO_PAGAMENTO (
  id SERIAL NOT NULL PRIMARY KEY,
  tipo VARCHAR NOT NULL,
  pagamento_online BOOL NOT NULL
);

CREATE TABLE FORMA_PAGAMENTO (
  id SERIAL NOT NULL PRIMARY KEY,
  id_tipo_pagamento SERIAL NOT NULL,
  descricao VARCHAR NOT NULL
);

CREATE TABLE USUARIO (
  id SERIAL NOT NULL PRIMARY KEY,
  email VARCHAR NOT NULL,
  id_forma_pagamento SERIAL NOT NULL
);

CREATE TABLE RESTAURANTE (
  id SERIAL NOT NULL PRIMARY KEY,
  nome VARCHAR NOT NULL,
  id_forma_pagamento SERIAL NOT NULL
);

ALTER TABLE public.restaurante ADD CONSTRAINT restaurante_un UNIQUE (nome,id_forma_pagamento);
ALTER TABLE public.forma_pagamento ADD CONSTRAINT forma_pagamento_un UNIQUE (id_tipo_pagamento);
ALTER TABLE public.usuario ADD CONSTRAINT usuario_un UNIQUE (email,id_forma_pagamento);

ALTER TABLE public.forma_pagamento ADD CONSTRAINT forma_pagamento_fk FOREIGN KEY (id_tipo_pagamento) REFERENCES public.tipo_pagamento(id);
ALTER TABLE public.restaurante ADD CONSTRAINT restaurante_fk FOREIGN KEY (id_forma_pagamento) REFERENCES public.forma_pagamento(id);
ALTER TABLE public.usuario ADD CONSTRAINT usuario_fk FOREIGN KEY (id_forma_pagamento) REFERENCES public.forma_pagamento(id);
