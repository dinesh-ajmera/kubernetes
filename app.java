@Controller
public class SudokuController {
    @Autowired
    private SudokuService sudokuService;

    @GetMapping("/")
    public String index(Model model) {
        SudokuBoard board = sudokuService.getNewBoard();
        model.addAttribute("board", board);
        return "index";
    }

    @PostMapping("/")
    public String solve(@ModelAttribute("board") SudokuBoard board, Model model) {
        if (sudokuService.isValid(board)) {
            if (sudokuService.solve(board)) {
                model.addAttribute("board", board);
                return "solution";
            } else {
                model.addAttribute("error", "Unable to solve the puzzle.");
                return "index";
            }
        } else {
            model.addAttribute("error", "Invalid board. Please check your input.");
            return "index";
        }
    }
}

@Service
public class SudokuServiceImpl implements SudokuService {
    @Override
    public SudokuBoard getNewBoard() {
        // code to generate new Sudoku board
    }

    @Override
    public boolean isValid(SudokuBoard board) {
        // code to check if the board is valid
    }

    @Override
    public boolean solve(SudokuBoard board) {
        // code to solve the Sudoku puzzle
    }
}

public class SudokuBoard {
    private int[][] board;

    public SudokuBoard(int[][] board) {
        this.board = board;
    }

    // getters and setters
}

public interface SudokuService {
    SudokuBoard getNewBoard();
    boolean isValid(SudokuBoard board);
    boolean solve(SudokuBoard board);
}