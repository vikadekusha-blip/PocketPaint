Pocket Paint to lekki edytor graficzny w wersji okienkowej, stworzony w języku Java przy użyciu biblioteki Swing. Aplikacja pozwala użytkownikowi na interaktywne rysowanie na cyfrowym płótnie za pomocą myszy oraz dostosowywanie narzędzi malarskich w czasie rzeczywistym.

Główne funkcje i możliwości aplikacji:

1. Rysowanie swobodne (Pędzel): Tworzenie płynnych linii odręcznych poprzez kliknięcie i przeciąganie myszy po ekranie.
2. Kształty geometryczne: Narzędzia do precyzyjnego rysowania linii prostych, prostokątów oraz owali (kół).
3. Zaawansowana paleta kolorów: Zintegrowane systemowe okno wyboru koloru (JColorChooser), które pozwala wybrać dowolny odcień.
4. Regulacja grubości: Wygodny suwak (JSlider) do płynnej zmiany rozmiaru pędzla, gumki lub linii.
5. Gumka (Eraser): Narzędzie do wymazywania elementów z płótna (malowanie kolorem tła).
7. Cofanie operacji (Undo): Możliwość szybkiego usunięcia ostatnio narysowanego elementu za pomocą przycisku lub klasycznego skrótu klawiszowego Ctrl+Z.
6. Czyszczenie płótna (Clear): Przycisk, który natychmiast resetuje sesję i przywraca czyste, białe tło.

Aplikacja została zaprojektowana zgodnie z zasadami programowania obiektowego (OOP):

1. Każdy obiekt na ekranie (linia, prostokąt, owal) dziedziczy po wspólnej klasie abstrakcyjnej Shape.
2. Program przechowuje historię rysunku w dynamicznej liście (ArrayList).
3. Podczas odświeżania ekranu aplikacja używa polimorfizmu — automatycznie przelatuje przez listę obiektów i wywołuje uniwersalną metodę .draw(), dzięki czemu każdy kształt sam wie, jak poprawnie wyrenderować się na płótnie.
Aplikacja cechuje się intuicyjnym interfejsem użytkownika (GUI) i stabilnym działaniem, łącząc prostotę obsługi z elastycznością kodu.

Jak uruchomić?

1. Skompiluj plik PocketPaint.java, PaintPanel.java, Shapes.java, Shape.java,  w dowolnym środowisku Java (np. IntelliJ IDEA).
2. Uruchom program.
