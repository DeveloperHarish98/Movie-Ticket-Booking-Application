-- Movie Ticket Booking System - Sample Data Script
-- This script inserts sample data for testing the application

-- Insert 3 Theatres
INSERT INTO theatres (id, name, location) VALUES 
(1, 'PVR Cinemas', 'Ambhuja City Mall'),
(2, 'INOX Movies', 'City Center Mall'),
(3, 'Cinepolis', 'Colours Mall');

-- Insert 9 Movies
INSERT INTO movies (id, title, duration_minutes, language, rating) VALUES 
(1, 'Avengers: Endgame', 181, 'English', 'PG-13'),
(2, 'Dangal', 161, 'Hindi', 'U'),
(3, 'Baahubali 2', 167, 'Telugu', 'U/A'),
(4, '3 Idiots', 170, 'Hindi', 'U'),
(5, 'Spider-Man: No Way Home', 148, 'English', 'PG-13'),
(6, 'KGF Chapter 2', 156, 'Kannada', 'U/A'),
(7, 'RRR', 187, 'Telugu', 'U/A'),
(8, 'The Dark Knight', 152, 'English', 'PG-13'),
(9, 'Dil Chahta Hai', 183, 'Hindi', 'U/A');

-- Insert Seats for each theatre (100 seats per theatre with different prices)
-- Theatre 1 - PVR Cinemas
INSERT INTO seats (id, seat_number, type, price, theatre_id) VALUES
-- Row A (Premium seats - ₹500)
(1, 'A1', 'PREMIUM', 500.00, 1), (2, 'A2', 'PREMIUM', 500.00, 1), (3, 'A3', 'PREMIUM', 500.00, 1), (4, 'A4', 'PREMIUM', 500.00, 1), (5, 'A5', 'PREMIUM', 500.00, 1),
(6, 'A6', 'PREMIUM', 500.00, 1), (7, 'A7', 'PREMIUM', 500.00, 1), (8, 'A8', 'PREMIUM', 500.00, 1), (9, 'A9', 'PREMIUM', 500.00, 1), (10, 'A10', 'PREMIUM', 500.00, 1),
-- Row B (Premium seats - ₹500)
(11, 'B1', 'PREMIUM', 500.00, 1), (12, 'B2', 'PREMIUM', 500.00, 1), (13, 'B3', 'PREMIUM', 500.00, 1), (14, 'B4', 'PREMIUM', 500.00, 1), (15, 'B5', 'PREMIUM', 500.00, 1),
(16, 'B6', 'PREMIUM', 500.00, 1), (17, 'B7', 'PREMIUM', 500.00, 1), (18, 'B8', 'PREMIUM', 500.00, 1), (19, 'B9', 'PREMIUM', 500.00, 1), (20, 'B10', 'PREMIUM', 500.00, 1),
-- Row C (Executive seats - ₹350)
(21, 'C1', 'EXECUTIVE', 350.00, 1), (22, 'C2', 'EXECUTIVE', 350.00, 1), (23, 'C3', 'EXECUTIVE', 350.00, 1), (24, 'C4', 'EXECUTIVE', 350.00, 1), (25, 'C5', 'EXECUTIVE', 350.00, 1),
(26, 'C6', 'EXECUTIVE', 350.00, 1), (27, 'C7', 'EXECUTIVE', 350.00, 1), (28, 'C8', 'EXECUTIVE', 350.00, 1), (29, 'C9', 'EXECUTIVE', 350.00, 1), (30, 'C10', 'EXECUTIVE', 350.00, 1),
-- Row D (Executive seats - ₹350)
(31, 'D1', 'EXECUTIVE', 350.00, 1), (32, 'D2', 'EXECUTIVE', 350.00, 1), (33, 'D3', 'EXECUTIVE', 350.00, 1), (34, 'D4', 'EXECUTIVE', 350.00, 1), (35, 'D5', 'EXECUTIVE', 350.00, 1),
(36, 'D6', 'EXECUTIVE', 350.00, 1), (37, 'D7', 'EXECUTIVE', 350.00, 1), (38, 'D8', 'EXECUTIVE', 350.00, 1), (39, 'D9', 'EXECUTIVE', 350.00, 1), (40, 'D10', 'EXECUTIVE', 350.00, 1),
-- Row E (Normal seats - ₹200)
(41, 'E1', 'NORMAL', 200.00, 1), (42, 'E2', 'NORMAL', 200.00, 1), (43, 'E3', 'NORMAL', 200.00, 1), (44, 'E4', 'NORMAL', 200.00, 1), (45, 'E5', 'NORMAL', 200.00, 1),
(46, 'E6', 'NORMAL', 200.00, 1), (47, 'E7', 'NORMAL', 200.00, 1), (48, 'E8', 'NORMAL', 200.00, 1), (49, 'E9', 'NORMAL', 200.00, 1), (50, 'E10', 'NORMAL', 200.00, 1),
-- Row F (Normal seats - ₹200)
(51, 'F1', 'NORMAL', 200.00, 1), (52, 'F2', 'NORMAL', 200.00, 1), (53, 'F3', 'NORMAL', 200.00, 1), (54, 'F4', 'NORMAL', 200.00, 1), (55, 'F5', 'NORMAL', 200.00, 1),
(56, 'F6', 'NORMAL', 200.00, 1), (57, 'F7', 'NORMAL', 200.00, 1), (58, 'F8', 'NORMAL', 200.00, 1), (59, 'F9', 'NORMAL', 200.00, 1), (60, 'F10', 'NORMAL', 200.00, 1),
-- Row G (Normal seats - ₹200)
(61, 'G1', 'NORMAL', 200.00, 1), (62, 'G2', 'NORMAL', 200.00, 1), (63, 'G3', 'NORMAL', 200.00, 1), (64, 'G4', 'NORMAL', 200.00, 1), (65, 'G5', 'NORMAL', 200.00, 1),
(66, 'G6', 'NORMAL', 200.00, 1), (67, 'G7', 'NORMAL', 200.00, 1), (68, 'G8', 'NORMAL', 200.00, 1), (69, 'G9', 'NORMAL', 200.00, 1), (70, 'G10', 'NORMAL', 200.00, 1),
-- Row H (Normal seats - ₹200)
(71, 'H1', 'NORMAL', 200.00, 1), (72, 'H2', 'NORMAL', 200.00, 1), (73, 'H3', 'NORMAL', 200.00, 1), (74, 'H4', 'NORMAL', 200.00, 1), (75, 'H5', 'NORMAL', 200.00, 1),
(76, 'H6', 'NORMAL', 200.00, 1), (77, 'H7', 'NORMAL', 200.00, 1), (78, 'H8', 'NORMAL', 200.00, 1), (79, 'H9', 'NORMAL', 200.00, 1), (80, 'H10', 'NORMAL', 200.00, 1),
-- Row I (Normal seats - ₹200)
(81, 'I1', 'NORMAL', 200.00, 1), (82, 'I2', 'NORMAL', 200.00, 1), (83, 'I3', 'NORMAL', 200.00, 1), (84, 'I4', 'NORMAL', 200.00, 1), (85, 'I5', 'NORMAL', 200.00, 1),
(86, 'I6', 'NORMAL', 200.00, 1), (87, 'I7', 'NORMAL', 200.00, 1), (88, 'I8', 'NORMAL', 200.00, 1), (89, 'I9', 'NORMAL', 200.00, 1), (90, 'I10', 'NORMAL', 200.00, 1),
-- Row J (Normal seats - ₹200)
(91, 'J1', 'NORMAL', 200.00, 1), (92, 'J2', 'NORMAL', 200.00, 1), (93, 'J3', 'NORMAL', 200.00, 1), (94, 'J4', 'NORMAL', 200.00, 1), (95, 'J5', 'NORMAL', 200.00, 1),
(96, 'J6', 'NORMAL', 200.00, 1), (97, 'J7', 'NORMAL', 200.00, 1), (98, 'J8', 'NORMAL', 200.00, 1), (99, 'J9', 'NORMAL', 200.00, 1), (100, 'J10', 'NORMAL', 200.00, 1);

-- Theatre 2 - INOX Movies (Seats 101-200)
INSERT INTO seats (id, seat_number, type, price, theatre_id) VALUES
-- Row A (Premium seats - ₹550)
(101, 'A1', 'PREMIUM', 550.00, 2), (102, 'A2', 'PREMIUM', 550.00, 2), (103, 'A3', 'PREMIUM', 550.00, 2), (104, 'A4', 'PREMIUM', 550.00, 2), (105, 'A5', 'PREMIUM', 550.00, 2),
(106, 'A6', 'PREMIUM', 550.00, 2), (107, 'A7', 'PREMIUM', 550.00, 2), (108, 'A8', 'PREMIUM', 550.00, 2), (109, 'A9', 'PREMIUM', 550.00, 2), (110, 'A10', 'PREMIUM', 550.00, 2),
-- Row B (Premium seats - ₹550)
(111, 'B1', 'PREMIUM', 550.00, 2), (112, 'B2', 'PREMIUM', 550.00, 2), (113, 'B3', 'PREMIUM', 550.00, 2), (114, 'B4', 'PREMIUM', 550.00, 2), (115, 'B5', 'PREMIUM', 550.00, 2),
(116, 'B6', 'PREMIUM', 550.00, 2), (117, 'B7', 'PREMIUM', 550.00, 2), (118, 'B8', 'PREMIUM', 550.00, 2), (119, 'B9', 'PREMIUM', 550.00, 2), (120, 'B10', 'PREMIUM', 550.00, 2),
-- Row C (Executive seats - ₹400)
(121, 'C1', 'EXECUTIVE', 400.00, 2), (122, 'C2', 'EXECUTIVE', 400.00, 2), (123, 'C3', 'EXECUTIVE', 400.00, 2), (124, 'C4', 'EXECUTIVE', 400.00, 2), (125, 'C5', 'EXECUTIVE', 400.00, 2),
(126, 'C6', 'EXECUTIVE', 400.00, 2), (127, 'C7', 'EXECUTIVE', 400.00, 2), (128, 'C8', 'EXECUTIVE', 400.00, 2), (129, 'C9', 'EXECUTIVE', 400.00, 2), (130, 'C10', 'EXECUTIVE', 400.00, 2),
-- Row D (Executive seats - ₹400)
(131, 'D1', 'EXECUTIVE', 400.00, 2), (132, 'D2', 'EXECUTIVE', 400.00, 2), (133, 'D3', 'EXECUTIVE', 400.00, 2), (134, 'D4', 'EXECUTIVE', 400.00, 2), (135, 'D5', 'EXECUTIVE', 400.00, 2),
(136, 'D6', 'EXECUTIVE', 400.00, 2), (137, 'D7', 'EXECUTIVE', 400.00, 2), (138, 'D8', 'EXECUTIVE', 400.00, 2), (139, 'D9', 'EXECUTIVE', 400.00, 2), (140, 'D10', 'EXECUTIVE', 400.00, 2),
-- Row E (Normal seats - ₹250)
(141, 'E1', 'NORMAL', 250.00, 2), (142, 'E2', 'NORMAL', 250.00, 2), (143, 'E3', 'NORMAL', 250.00, 2), (144, 'E4', 'NORMAL', 250.00, 2), (145, 'E5', 'NORMAL', 250.00, 2),
(146, 'E6', 'NORMAL', 250.00, 2), (147, 'E7', 'NORMAL', 250.00, 2), (148, 'E8', 'NORMAL', 250.00, 2), (149, 'E9', 'NORMAL', 250.00, 2), (150, 'E10', 'NORMAL', 250.00, 2),
-- Row F (Normal seats - ₹250)
(151, 'F1', 'NORMAL', 250.00, 2), (152, 'F2', 'NORMAL', 250.00, 2), (153, 'F3', 'NORMAL', 250.00, 2), (154, 'F4', 'NORMAL', 250.00, 2), (155, 'F5', 'NORMAL', 250.00, 2),
(156, 'F6', 'NORMAL', 250.00, 2), (157, 'F7', 'NORMAL', 250.00, 2), (158, 'F8', 'NORMAL', 250.00, 2), (159, 'F9', 'NORMAL', 250.00, 2), (160, 'F10', 'NORMAL', 250.00, 2),
-- Row G (Normal seats - ₹250)
(161, 'G1', 'NORMAL', 250.00, 2), (162, 'G2', 'NORMAL', 250.00, 2), (163, 'G3', 'NORMAL', 250.00, 2), (164, 'G4', 'NORMAL', 250.00, 2), (165, 'G5', 'NORMAL', 250.00, 2),
(166, 'G6', 'NORMAL', 250.00, 2), (167, 'G7', 'NORMAL', 250.00, 2), (168, 'G8', 'NORMAL', 250.00, 2), (169, 'G9', 'NORMAL', 250.00, 2), (170, 'G10', 'NORMAL', 250.00, 2),
-- Row H (Normal seats - ₹250)
(171, 'H1', 'NORMAL', 250.00, 2), (172, 'H2', 'NORMAL', 250.00, 2), (173, 'H3', 'NORMAL', 250.00, 2), (174, 'H4', 'NORMAL', 250.00, 2), (175, 'H5', 'NORMAL', 250.00, 2),
(176, 'H6', 'NORMAL', 250.00, 2), (177, 'H7', 'NORMAL', 250.00, 2), (178, 'H8', 'NORMAL', 250.00, 2), (179, 'H9', 'NORMAL', 250.00, 2), (180, 'H10', 'NORMAL', 250.00, 2),
-- Row I (Normal seats - ₹250)
(181, 'I1', 'NORMAL', 250.00, 2), (182, 'I2', 'NORMAL', 250.00, 2), (183, 'I3', 'NORMAL', 250.00, 2), (184, 'I4', 'NORMAL', 250.00, 2), (185, 'I5', 'NORMAL', 250.00, 2),
(186, 'I6', 'NORMAL', 250.00, 2), (187, 'I7', 'NORMAL', 250.00, 2), (188, 'I8', 'NORMAL', 250.00, 2), (189, 'I9', 'NORMAL', 250.00, 2), (190, 'I10', 'NORMAL', 250.00, 2),
-- Row J (Normal seats - ₹250)
(191, 'J1', 'NORMAL', 250.00, 2), (192, 'J2', 'NORMAL', 250.00, 2), (193, 'J3', 'NORMAL', 250.00, 2), (194, 'J4', 'NORMAL', 250.00, 2), (195, 'J5', 'NORMAL', 250.00, 2),
(196, 'J6', 'NORMAL', 250.00, 2), (197, 'J7', 'NORMAL', 250.00, 2), (198, 'J8', 'NORMAL', 250.00, 2), (199, 'J9', 'NORMAL', 250.00, 2), (200, 'J10', 'NORMAL', 250.00, 2);

-- Theatre 3 - Cinepolis (Seats 201-300)
INSERT INTO seats (id, seat_number, type, price, theatre_id) VALUES
-- Row A (Premium seats - ₹600)
(201, 'A1', 'PREMIUM', 600.00, 3), (202, 'A2', 'PREMIUM', 600.00, 3), (203, 'A3', 'PREMIUM', 600.00, 3), (204, 'A4', 'PREMIUM', 600.00, 3), (205, 'A5', 'PREMIUM', 600.00, 3),
(206, 'A6', 'PREMIUM', 600.00, 3), (207, 'A7', 'PREMIUM', 600.00, 3), (208, 'A8', 'PREMIUM', 600.00, 3), (209, 'A9', 'PREMIUM', 600.00, 3), (210, 'A10', 'PREMIUM', 600.00, 3),
-- Row B (Premium seats - ₹600)
(211, 'B1', 'PREMIUM', 600.00, 3), (212, 'B2', 'PREMIUM', 600.00, 3), (213, 'B3', 'PREMIUM', 600.00, 3), (214, 'B4', 'PREMIUM', 600.00, 3), (215, 'B5', 'PREMIUM', 600.00, 3),
(216, 'B6', 'PREMIUM', 600.00, 3), (217, 'B7', 'PREMIUM', 600.00, 3), (218, 'B8', 'PREMIUM', 600.00, 3), (219, 'B9', 'PREMIUM', 600.00, 3), (220, 'B10', 'PREMIUM', 600.00, 3),
-- Row C (Executive seats - ₹450)
(221, 'C1', 'EXECUTIVE', 450.00, 3), (222, 'C2', 'EXECUTIVE', 450.00, 3), (223, 'C3', 'EXECUTIVE', 450.00, 3), (224, 'C4', 'EXECUTIVE', 450.00, 3), (225, 'C5', 'EXECUTIVE', 450.00, 3),
(226, 'C6', 'EXECUTIVE', 450.00, 3), (227, 'C7', 'EXECUTIVE', 450.00, 3), (228, 'C8', 'EXECUTIVE', 450.00, 3), (229, 'C9', 'EXECUTIVE', 450.00, 3), (230, 'C10', 'EXECUTIVE', 450.00, 3),
-- Row D (Executive seats - ₹450)
(231, 'D1', 'EXECUTIVE', 450.00, 3), (232, 'D2', 'EXECUTIVE', 450.00, 3), (233, 'D3', 'EXECUTIVE', 450.00, 3), (234, 'D4', 'EXECUTIVE', 450.00, 3), (235, 'D5', 'EXECUTIVE', 450.00, 3),
(236, 'D6', 'EXECUTIVE', 450.00, 3), (237, 'D7', 'EXECUTIVE', 450.00, 3), (238, 'D8', 'EXECUTIVE', 450.00, 3), (239, 'D9', 'EXECUTIVE', 450.00, 3), (240, 'D10', 'EXECUTIVE', 450.00, 3),
-- Row E (Normal seats - ₹300)
(241, 'E1', 'NORMAL', 300.00, 3), (242, 'E2', 'NORMAL', 300.00, 3), (243, 'E3', 'NORMAL', 300.00, 3), (244, 'E4', 'NORMAL', 300.00, 3), (245, 'E5', 'NORMAL', 300.00, 3),
(246, 'E6', 'NORMAL', 300.00, 3), (247, 'E7', 'NORMAL', 300.00, 3), (248, 'E8', 'NORMAL', 300.00, 3), (249, 'E9', 'NORMAL', 300.00, 3), (250, 'E10', 'NORMAL', 300.00, 3),
-- Row F (Normal seats - ₹300)
(251, 'F1', 'NORMAL', 300.00, 3), (252, 'F2', 'NORMAL', 300.00, 3), (253, 'F3', 'NORMAL', 300.00, 3), (254, 'F4', 'NORMAL', 300.00, 3), (255, 'F5', 'NORMAL', 300.00, 3),
(256, 'F6', 'NORMAL', 300.00, 3), (257, 'F7', 'NORMAL', 300.00, 3), (258, 'F8', 'NORMAL', 300.00, 3), (259, 'F9', 'NORMAL', 300.00, 3), (260, 'F10', 'NORMAL', 300.00, 3),
-- Row G (Normal seats - ₹300)
(261, 'G1', 'NORMAL', 300.00, 3), (262, 'G2', 'NORMAL', 300.00, 3), (263, 'G3', 'NORMAL', 300.00, 3), (264, 'G4', 'NORMAL', 300.00, 3), (265, 'G5', 'NORMAL', 300.00, 3),
(266, 'G6', 'NORMAL', 300.00, 3), (267, 'G7', 'NORMAL', 300.00, 3), (268, 'G8', 'NORMAL', 300.00, 3), (269, 'G9', 'NORMAL', 300.00, 3), (270, 'G10', 'NORMAL', 300.00, 3),
-- Row H (Normal seats - ₹300)
(271, 'H1', 'NORMAL', 300.00, 3), (272, 'H2', 'NORMAL', 300.00, 3), (273, 'H3', 'NORMAL', 300.00, 3), (274, 'H4', 'NORMAL', 300.00, 3), (275, 'H5', 'NORMAL', 300.00, 3),
(276, 'H6', 'NORMAL', 300.00, 3), (277, 'H7', 'NORMAL', 300.00, 3), (278, 'H8', 'NORMAL', 300.00, 3), (279, 'H9', 'NORMAL', 300.00, 3), (280, 'H10', 'NORMAL', 300.00, 3),
-- Row I (Normal seats - ₹300)
(281, 'I1', 'NORMAL', 300.00, 3), (282, 'I2', 'NORMAL', 300.00, 3), (283, 'I3', 'NORMAL', 300.00, 3), (284, 'I4', 'NORMAL', 300.00, 3), (285, 'I5', 'NORMAL', 300.00, 3),
(286, 'I6', 'NORMAL', 300.00, 3), (287, 'I7', 'NORMAL', 300.00, 3), (288, 'I8', 'NORMAL', 300.00, 3), (289, 'I9', 'NORMAL', 300.00, 3), (290, 'I10', 'NORMAL', 300.00, 3),
-- Row J (Normal seats - ₹300)
(291, 'J1', 'NORMAL', 300.00, 3), (292, 'J2', 'NORMAL', 300.00, 3), (293, 'J3', 'NORMAL', 300.00, 3), (294, 'J4', 'NORMAL', 300.00, 3), (295, 'J5', 'NORMAL', 300.00, 3),
(296, 'J6', 'NORMAL', 300.00, 3), (297, 'J7', 'NORMAL', 300.00, 3), (298, 'J8', 'NORMAL', 300.00, 3), (299, 'J9', 'NORMAL', 300.00, 3), (300, 'J10', 'NORMAL', 300.00, 3);

-- Insert Sample Users
INSERT INTO users (id, name, email, phone) VALUES 
(1, 'Harry', 'harry@gmail.com', '9876543210'),
(2, 'Hrishikesh', 'hrishikesh@gmail.com', '9876543211'),
(3, 'Thaneshwar', 'thaneshwar@gmail.com', '9876543212'),
(4, 'Kunj', 'kunj@gmail.com', '9876543213'),
(5, 'Manish', 'manish@gmail.com', '9876543214');
(6, 'DevDeep', 'devdeep@gmail.com', '9876543214');

-- Insert Shows for Today (3 shows per day per theatre - Morning, Afternoon, Evening)
INSERT INTO shows (id, show_time, movie_id, theatre_id) VALUES
-- Theatre 1 - PVR Cinemas - Today
(1, '2024-02-13 09:00:00', 1, 1), (2, '2024-02-13 14:00:00', 2, 1), (3, '2024-02-13 18:00:00', 3, 1),
-- Theatre 1 - Tomorrow  
(4, '2024-02-14 09:00:00', 4, 1), (5, '2024-02-14 14:00:00', 5, 1), (6, '2024-02-14 18:00:00', 6, 1),
-- Theatre 2 - INOX Movies - Today
(7, '2024-02-13 10:00:00', 7, 2), (8, '2024-02-13 15:00:00', 8, 2), (9, '2024-02-13 19:00:00', 9, 2),
-- Theatre 2 - Tomorrow
(10, '2024-02-14 10:00:00', 1, 2), (11, '2024-02-14 15:00:00', 2, 2), (12, '2024-02-14 19:00:00', 3, 2),
-- Theatre 3 - Cinepolis - Today
(13, '2024-02-13 11:00:00', 4, 3), (14, '2024-02-13 16:00:00', 5, 3), (15, '2024-02-13 20:00:00', 6, 3),
-- Theatre 3 - Tomorrow
(16, '2024-02-14 11:00:00', 7, 3), (17, '2024-02-14 16:00:00', 8, 3), (18, '2024-02-14 20:00:00', 9, 3);

-- Insert Sample Users
INSERT INTO users (id, name, email, phone) VALUES 
(1, 'John Doe', 'john.doe@example.com', '9876543210'),
(2, 'Jane Smith', 'jane.smith@example.com', '9876543211'),
(3, 'Mike Johnson', 'mike.johnson@example.com', '9876543212'),
(4, 'Sarah Williams', 'sarah.williams@example.com', '9876543213'),
(5, 'David Brown', 'david.brown@example.com', '9876543214');

-- Note: ShowSeats will be automatically created when shows are created via the application
-- The ShowService.createShow() method automatically creates ShowSeat entries for all seats in the theatre
-- Each show will have 100 ShowSeat entries with status AVAILABLE

-- Sample booking data (optional - for testing)
-- You can create bookings through the API endpoints after running the application

COMMIT;
