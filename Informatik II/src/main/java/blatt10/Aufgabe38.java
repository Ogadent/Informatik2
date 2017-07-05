public void load(BuchContainer container) {
	try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM Buch")) {
		final ResultSet result = stmt.executeQuery();
		while (result.next()) {
			final Buch buch = new Buch(result.getString("isbn"), result.getString("title"));
			container.linkBuchFrom(buch);
		}
	} catch (SQLException e) {
		throw new LoadSaveException(e.getMessage(), e);
	}
}
