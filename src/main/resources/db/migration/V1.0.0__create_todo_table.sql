create table if not exists todo (
    id BIGSERIAL PRIMARY KEY,
    task varchar,
    is_completed BOOLEAN NOT NULL
);