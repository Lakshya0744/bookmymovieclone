export default function Navbar() {
  return (
    <nav className="bg-gray-900 text-white px-8 py-4 flex items-center justify-between">
      {/* Logo */}
      <div className="text-2xl font-bold">BookMyMovie</div>

      {/* Navigation Links */}
      <div className="flex gap-6">
        <a href="#" className="hover:text-red-500">Movies</a>
      </div>

      {/* Search + Profile */}
      <div className="flex items-center gap-4">
        <input
          type="text"
          placeholder="Search for Movies, Events..."
          className="px-3 py-1 rounded-lg text-black"
        />
        <button className="bg-red-500 px-4 py-1 rounded-lg hover:bg-red-600">
          Sign In
        </button>
      </div>
    </nav>
  );
}