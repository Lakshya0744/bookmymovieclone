import React from "react";
import { Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import MovieGrid from "./components/MovieGrid";
import HeroBanner from "./components/HeroBanner";
import ShowtimesPage from "./components/ShowtimesPage";

export default function App() {
  return (
    <div className="min-h-screen bg-black text-white flex flex-col">
      <Navbar />

      <main className="flex-1 w-full p-0">
          <Routes>
            {/* Home Page */}
            <Route
              path="/"
              element={
                <>
                  <HeroBanner />
                  <section className="mt-8">
                    <h1 className="text-3xl font-bold mb-4 pl-6">Now Showing</h1>
                    <MovieGrid />
                  </section>
                </>
              }
            />

            {/* Showtimes Page */}
            <Route path="/showtimes/:id" element={<ShowtimesPage />} />
          </Routes>
      </main>

      <footer className="bg-gray-900 text-white text-center py-6 mt-12">
        &copy; {new Date().getFullYear()} BookMyShow Clone
      </footer>
    </div>
  );
}