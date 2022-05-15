CREATE TABLE IF NOT EXISTS user
(
    `id`         INTEGER AUTO_INCREMENT NOT NULL UNIQUE,
    `username` TEXT NOT NULL UNIQUE,
    `password` TEXT NOT NULL,
    `level` TEXT NOT NULL,
    PRIMARY KEY (`id`)
);
