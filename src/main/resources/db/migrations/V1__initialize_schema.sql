CREATE TABLE users (
	id SERIAL PRIMARY KEY,
	username VARCHAR(25) NOT NULL UNIQUE,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL UNIQUE,
	password VARCHAR(200) NOT NULL,
	created_at TIMESTAMP DEFAULT now(),
	deleted_at TIMESTAMP,
    roles VARCHAR(20) NOT NULL
);

CREATE TABLE note(
	id SERIAL PRIMARY KEY,
	author_id INT NOT NULL,
	title VARCHAR(255) NOT NULL,
	content_path VARCHAR(255) NOT NULL,
	created_at TIMESTAMP DEFAULT now(),
	modified_at TIMESTAMP,
	deleted_at TIMESTAMP,
	FOREIGN KEY (author_id) REFERENCES users(id)
);

CREATE TABLE category(
	id SERIAL PRIMARY KEY,
	category VARCHAR(50) NOT NULL
);

CREATE TABLE note_category(
	note_id INT,
	category_id INT,
	PRIMARY KEY(note_id, category_id),
	FOREIGN KEY (note_id) REFERENCES note(id),
	FOREIGN KEY (category_id) REFERENCES category(id)
);
