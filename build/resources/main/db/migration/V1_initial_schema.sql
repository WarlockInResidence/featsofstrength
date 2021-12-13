-- drop all the tables while testing
-- DROP TABLE IF EXISTS fos;
-- DROP TABLE IF EXISTS players;



-- generate tables
CREATE TABLE if not exists players
(
    id serial,
    player_name varchar(64),
    player_url varchar(64),
    game_1_score numeric,
    game_2_score numeric,
    PRIMARY KEY (id)
);