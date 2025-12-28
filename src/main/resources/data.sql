INSERT INTO projects (title, short_description, image_url, city, lat, lng, goal_amount, current_amount, status)
VALUES ('Очищення парку', 'Збираємо волонтерів для прибирання', 'https://picsum.photos/400/300', 'Київ', 50.45, 30.52, 10000.0, 1500.0, 'ACTIVE');

INSERT INTO projects (title, short_description, image_url, city, lat, lng, goal_amount, current_amount, status)
VALUES ('Сортування сміття', 'Встановлення баків у школі', 'https://picsum.photos/400/301', 'Львів', 49.83, 24.02, 5000.0, 4800.0, 'ACTIVE');

INSERT INTO users (name, email, avatar_url)
VALUES ('Володимир', 'vol@eco.com', 'https://placehold.co/200x200/2ecc71/white?text=V');

INSERT INTO donations (user_id, project_id, amount, created_at)
VALUES (1, 1, 500.0, CURRENT_TIMESTAMP);

INSERT INTO donations (user_id, project_id, amount, created_at)
VALUES (1, 2, 1200.0, CURRENT_TIMESTAMP);