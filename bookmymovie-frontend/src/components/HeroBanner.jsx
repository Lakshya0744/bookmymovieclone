import React, { useEffect, useState } from "react";

export default function HeroBanner() {
  const [bannerUrl, setBannerUrl] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const apiBase = window.RUNTIME_CONFIG?.API_BASE || "http://localhost:8081";
console.log("window.RUNTIME_CONFIG", window.RUNTIME_CONFIG);
  useEffect(() => {
    const controller = new AbortController();

    async function loadBanner() {
      try {
        setLoading(true);
        setError(null);

        const res = await fetch(`${apiBase}/banner`, { signal: controller.signal });
        if (!res.ok) {
          throw new Error(`Server error: ${res.status}`);
        }

        const data = await res.json();

        // Fix relative URL
        if (data?.bannerUrl && data.bannerUrl.startsWith("/")) {
          setBannerUrl(`${apiBase}${data.bannerUrl}`);
        } else {
          setBannerUrl(data.bannerUrl);
        }
      } catch (err) {
        if (err.name !== "AbortError") {
          console.error("Failed to load banner:", err);
          setError(err.message || "Failed to load banner");
        }
      } finally {
        setLoading(false);
      }
    }

    loadBanner();
    return () => controller.abort();
  }, [apiBase]);

  if (loading) {
    return (
      <section className="relative w-full h-screen flex items-center justify-center text-white">
        <div>Loading banner…</div>
      </section>
    );
  }

  if (error || !bannerUrl) {
    return (
      <section className="relative w-full h-screen flex items-center justify-center text-white bg-black">
        <div>Could not load banner.</div>
      </section>
    );
  }

  return (
    <section className="relative w-full h-screen overflow-hidden">
      {/* Background Video */}
      <video
        className="absolute inset-0 w-full h-full object-cover"
        src={bannerUrl}
        autoPlay
        loop
        muted
        playsInline
      />

      {/* Overlay */}
      <div className="absolute inset-0 bg-black bg-opacity-50"></div>

      {/* Content */}
      <div className="relative z-10 flex flex-col justify-center items-center h-full text-center text-white px-4">
        <h1 className="text-5xl font-bold mb-4">Book Your Movie Tickets Online</h1>
        <p className="text-lg max-w-2xl mb-6">
          Experience the magic of cinema — from blockbusters to indie gems, all at your fingertips.
        </p>
        <button className="bg-red-600 hover:bg-red-700 text-white font-semibold py-3 px-6 rounded-lg">
          Book Now
        </button>
      </div>
    </section>
  );
}