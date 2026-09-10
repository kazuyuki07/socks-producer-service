CREATE TABLE IF NOT EXISTS producers (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    company VARCHAR(50) NOT NULL,
    phone_number VARCHAR(20) UNIQUE NOT NULL,
    email VARCHAR(80) UNIQUE NOT NULL,
    status VARCHAR(10) NOT NULL CHECK (status IN ('ACTIVE', 'BLOCK'))
);