using Microsoft.EntityFrameworkCore;

namespace API.Models
{
    public class PasseioBd : DbContext
    {
        public ViagemDbContext(DbContextOptions<PasseioBd> options)
          : base(options)
        { }

        public DbSet<Passeio> passeios { get; set; }
    }
}
