CREATE TABLE IF NOT EXISTS user
(
    `id`         int AUTO_INCREMENT NOT NULL UNIQUE,
    `username` TEXT NOT NULL,
    `password` TEXT NOT NULL,
    `level` TEXT NOT NULL,
    PRIMARY KEY (`id`)
);
