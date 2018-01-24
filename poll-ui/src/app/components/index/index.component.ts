import {AfterViewInit, Component, Inject, OnInit} from '@angular/core';
import {QuestionService} from "../../services/question.service";
import {Question} from "../../dto/question.model";
import {DOCUMENT} from '@angular/common';
import {PollService} from "../../services/poll.service";
import {Poll} from "../../dto/poll.model";
import {AnswerItemModel} from "../../dto/answer.item.model";


@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  questions: Question[] = [];
  answers: number[] = [];
  url: string;
  showQRCode: boolean = false;
  polls: Poll[] = [];

  constructor(private questionService: QuestionService,
              @Inject(DOCUMENT) private document: Document,
              private pollService: PollService) {
    this.url = this.document.location.href;
    console.log(this.url);
  }

  ngOnInit() {
    this.questionService.getQuestions().subscribe(r => {
      this.questions = r;
    });
  }

  onSubmitButtonClicked()
  {
    this.pollService.submitPoll(this.polls).subscribe(r=>{
      console.log("post successful");

    });
  }


  onItemClick(qIndex: number, answerId: AnswerItemModel) {

    let poll = new Poll(this.questions[qIndex], answerId);
    this.polls[qIndex] = poll;
    console.log(this.polls);
  }

  isHighlighted(qIndex: number, answerId: AnswerItemModel): boolean {

    if (this.polls.length < qIndex) return false;

    if (this.polls[qIndex] != null && this.polls[qIndex].answer.id === answerId.id) return true;
    else return false;
  }


  onShowQRButonClicked() {
    this.showQRCode = !this.showQRCode;
  }
}
