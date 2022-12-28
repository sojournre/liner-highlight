INSERT INTO COLOR (color_hex) VALUES
('#ffff8d'),
('#a5f2e9'),
('#ffd5c8'),
('#f6f0aa'),
('#d3edd1'),
('#f9d6c1')
;

INSERT INTO USER (theme_id, email, password) VALUES
(1, 'admin@getliner.com', 'admin1234')
;

INSERT INTO THEME (user_id) VALUES
(1),
(1)
;

INSERT INTO THEME_COLOR (theme_id, color_id, sequence) VALUES
(1, 1, 1),
(1, 2, 2),
(1, 3, 3),
(2, 4, 1),
(2, 5, 2),
(2, 6, 3)
;