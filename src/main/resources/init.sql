-- Database: webshop sql

-- DROP DATABASE "webshop sql";
	
SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET default_tablespace = '';
SET default_with_oids = false;

DROP TABLE IF EXISTS Poets CASCADE;
DROP TABLE IF EXISTS Arts CASCADE;

CREATE TABLE Poets (
	id smallint NOT NULL,
	name character varying(20),
	password character varying(20),
	PRIMARY KEY(id)
);

CREATE TABLE Arts (
	id smallint NOT NULL,
	title character varying(50),
	content character varying(3000),
	poet_id smallint NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(poet_id) REFERENCES Poets(id)
);



INSERT INTO Poets VALUES (1, 'Edgar Allan Poe', 'raven');
INSERT INTO Poets VALUES (2, 'József Attila', 'vonat');

INSERT INTO Arts VALUES (1, 'The Raven',
        'Once upon a midnight dreary, while I pondered, weak and weary,
        <br>Over many a quaint and curious volume of forgotten lore—
        <br> While I nodded, nearly napping, suddenly there came a tapping,
        <br> As of some one gently rapping, rapping at my chamber door.
        <br>“’Tis some visitor,” I muttered, “tapping at my chamber door—
        <br>Only this and nothing more.”', 1);
INSERT INTO Arts VALUES (2, 'Alone',
        'From childhood’s hour I have not been
        <br>As others were—I have not seen
        <br>As others saw—I could not bring
        <br>My passions from a common spring—
        <br>From the same source I have not taken
        <br>My sorrow—I could not awaken
        <br>My heart to joy at the same tone—
        <br>And all I lov’d—I lov’d alone—
        <br>Then—in my childhood—in the dawn
        <br>Of a most stormy life—was drawn
        <br>From ev’ry depth of good and ill
        <br>The mystery which binds me still—
        <br>From the torrent, or the fountain—
        <br>From the red cliff of the mountain—
        <br>From the sun that ’round me roll’d
        <br>In its autumn tint of gold—
        <br>From the lightning in the sky
        <br>As it pass’d me flying by—
        <br>From the thunder, and the storm—
        <br>And the cloud that took the form
        <br>(When the rest of Heaven was blue)
        <br>Of a demon in my view—', 1);
INSERT INTO Arts VALUES (3, 'Születésnapomra',
        'Harminckét éves lettem én -
        <br>meglepetés e költemény
        <br>csecse
        <br>becse:
        <br>
        <br>ajándék, mellyel meglepem
        <br>e kávéházi szegleten
        <br>magam
        <br>magam.
        <br>
        <br>Harminckét évem elszelelt
        <br>s még havi kétszáz sose telt.
        <br>Az ám,
        <br>Hazám!
        <br>
        <br>Lehettem volna oktató,
        <br>nem ily töltőtoll koptató
        <br>szegény
        <br>legény.
        <br>
        <br>De nem lettem, mert Szegeden
        <br>eltanácsolt az egyetem
        <br>fura
        <br>ura.
        <br>
        <br>Intelme gyorsan, nyersen ért
        <br>a "Nincsen apám" versemért,
        <br>a hont
        <br>kivont
        <br>
        <br>szablyával óvta ellenem.
        <br>Ideidézi szellemem
        <br>hevét
        <br>s nevét:
        <br>
        <br>"Ön, amig szóból értek én,
        <br>nem lesz tanár e féltekén" -
        <br>gagyog
        <br>s ragyog.
        <br>
        <br>Ha örül Horger Antal úr,
        <br>hogy költőnk nem nyelvtant tanul,
        <br>sekély
        <br>e kéj -
        <br>
        <br>Én egész népemet fogom
        <br>nem középiskolás fokon
        <br>taní-
        <br>tani!', 2);
INSERT INTO Arts VALUES (4, 'Sportirodalom',
        'Sportirodalma, Takács, kedvessé tette a sportot
        <br>méla szememben, amely csak a sakk kockáin öregbült.
        <br>Már evezőt ragadok, gerelyem zug, röppen a diszkosz.
        <br>Holnapután kihuzom magamat; - s: milyen egy dali fickó -
        <br>így sóhajtnak utánam a lányok, még a Takács is.', 2);


